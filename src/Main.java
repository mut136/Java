
public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 10);

        Segment line = new Segment(p1, p2);
        System.out.println(line.toSvg());

        Point p3 = new Point(5,5);
        Segment[] arr = Segment.perpendicural(line,p3);

        System.out.println("x= " + arr[0].getP2().x + " y= " + arr[0].getP2().y);
        System.out.println("xp= " + arr[1].getP2().x + " yp= " + arr[1].getP2().y);

        Point[] points = new Point[4];
        points[0] = p1;
        points[1] = p2;
        points[2] = new Point(3, 3);
        points[3] = new Point(4, 4);

        Polygon polygon = new Polygon(points);
        System.out.println(polygon.toSvg());
    }

}