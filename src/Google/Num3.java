package Google;
import java.util.*;
//find if there is a line that's (x = i) could make all the points symmetric to this line
public class Num3 {
    public class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static double findSymmetric(Point[] points) {
        if (points == null || points.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        //use a hashmap to store all the x -> list<y>
        Map<Double, List<Integer>> map = new HashMap<>();
        //build up the map
        //scan through the points, find the median of the x value
        double median = 0;
        for (int i = 0; i < points.length; i++) {
            double x = points[i].x;
            int y = points[i].y;
            if (!map.containsKey(x))
                map.put(x, new ArrayList<Integer>());
            map.get(x).add(y);
            median += x;
        }
        median = median / (double)points.length;
        
        for (int i = 0; i < points.length; i++) {
            int x = points[i].x;
            int y = points[i].y;
            double x_1 = median * 2 - (double)x;
            if (!map.containsKey(x_1) || !map.get(x_1).contains(y)) 
                return Integer.MIN_VALUE;
            map.get(x_1).remove((Integer)y);
        }
        
        return median;
    }
    
    public static void main(String[] args) {
        Num3 q = new Num3();
        Point p1 = q.new Point(1,2);
        Point p3 = q.new Point(1,2);
        Point p2 = q.new Point(2,2);
        Point p4 = q.new Point(2,2);
        Point[] points = new Point[]{p1, p2, p3, p4};
        System.out.println(findSymmetric(points));
    }
}
