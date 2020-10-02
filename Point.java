class Point {
    public static double getDistanceBetween(int x1, int y1, int x2, int y2) {
        // distance equasion:
        // d = |sqrt( (x2 - x1)^2 + (y2 - y1)^2 )|

        double distance = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2);
        distance = Math.sqrt(distance);
        distance = Math.abs(distance);

        return distance;
    }
}
