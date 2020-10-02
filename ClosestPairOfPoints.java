import java.util.*;

class ClosestPairOfPoints {

    public static void main(String[] args) {
        String filepath = "data.txt";

        try {
            int[][] points = PointLoader.loadPoints(filepath);
            System.out.println(Arrays.deepToString(points));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

