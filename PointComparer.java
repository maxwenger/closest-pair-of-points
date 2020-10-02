import java.util.*;

class PointComparer {
    public static double findClosestPoint(int[][] points) {
        sortPointsByX(points);

        return findClosestPointRecur(points, 0, points.length); 
    }

    private static double findClosestPointRecur(int[][] points, int leftBound, int numberOfPoints) {
        int rightBound = leftBound + numberOfPoints - 1;
        int medianNumberOfPoints = numberOfPoints / 2;

        if(numberOfPoints <= 3) {
            return bruteForce(points, leftBound, rightBound);
        }

        double closestLeft = findClosestPointRecur(points, leftBound, medianNumberOfPoints);
        double closestRight = findClosestPointRecur(points, leftBound + medianNumberOfPoints, medianNumberOfPoints);

        double closest = Math.min(closestLeft, closestRight);

        return closest;
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
