import java.util.Arrays;

public class Polygon {
    private Point[] points;
    public Polygon(Point[] points){
        this.points = Arrays.copyOf(points, points.length);
    }

    public Polygon(Polygon pol) {
        points = new Point[pol.points.length];
        for  (int i = 0; i < pol.points.length; ++i) {
            points[i] = new Point(pol.points[i].x, pol.points[i].y);
        }
    }
    public String toSvg(){
        String res = "<polygon points=\"";
        for (Point point : points)
            res += point.x + "," + point.y + " ";
        res+="\"/>";
        return res;
    }
}
