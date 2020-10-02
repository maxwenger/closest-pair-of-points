import java.io.FileNotFoundException;
import java.util.*;

class ClosestPairOfPoints {

    public static void main(String[] args) {
        String filepath = "data.txt";

        try {
            int[][] points = PointLoader.loadPoints(filepath);
            System.out.println(PointComparer.findClosestPoint(points));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
    }
}

