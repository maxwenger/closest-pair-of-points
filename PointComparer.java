import java.util.*;

class PointComparer {
    public static double findClosestPoint(int[][] points) {
        sortPointsByX(points);

        return findClosestPointRecur(points, 0, points.length); 
    }

    private static double findClosestPointRecur(int[][] points, int leftBound, int numberOfPoints) {
        int rightBound = leftBound + numberOfPoints - 1;
        int medianNumberOfPoints = numberOfPoints / 2;
        int medianIndex = medianNumberOfPoints + leftBound;

        if(numberOfPoints <= 3) {
            return bruteForce(points, leftBound, rightBound);
        }

        double closestLeft = findClosestPointRecur(points, leftBound, medianNumberOfPoints);
        double closestRight = findClosestPointRecur(points, medianIndex, medianNumberOfPoints);

        double closest = Math.min(closestLeft, closestRight);

        ArrayList<int[]> strip = new ArrayList<int[]>();
        for(int i = leftBound; i < rightBound; i++) {
            if(Math.abs(points[i][0] - points[medianIndex][0]) <= closest) {
                strip.add(points[i]);
            }
        }

        int[][] stripArray = new int[strip.size()][];
        stripArray = strip.toArray(stripArray);
        closest = Math.min(closest, compareStrip(stripArray, closest));

        return closest;
    }

    public static double compareStrip(int[][] points, double distance) {
        double closest = distance;
        sortPointsByY(points);
        
        for(int i = 0; i < points.length; i ++) {
            for(int j = i + 1; j < points.length && (points[j][1] - points[i][1]) < closest; j++) {
                double curDistance = getDistanceBetween(points[i], points[j]);
                closest = Math.min(closest, curDistance);
            }
        }

        return closest;
    }

    private static void sortPointsByY(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
    }

    private static void sortPointsByX(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
    }

    private static double getDistanceBetween(int[] p1, int[] p2) {
        // distance equasion:
        // d = |sqrt( (x2 - x1)^2 + (y2 - y1)^2 )|

        double distance = Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2);
        distance = Math.sqrt(distance);
        distance = Math.abs(distance);

        return distance;
    }

    private static double bruteForce(int[][] points, int leftBound, int rightBound) {
        double closest = Double.MAX_VALUE;

        for(int i = leftBound; i < rightBound; i++) {
            for(int j = i + 1; j <= rightBound; j++) {
                double distance = getDistanceBetween(points[i], points[j]);
                closest = Math.min(distance, closest);
            }
        }

        return closest;
    }


}
