import java.util.Locale;

public class Segment {
    private Point p1;
    private Point p2;

    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public double distance() {
        return Math.hypot(p2.x - p1.x, p2.y - p1.y);
    }

    public String toSvg() {
        return String.format(Locale.ENGLISH, "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" />", p1.x, p1.y, p2.x, p2.y);
    }

    public static Segment[] perpendicural(Segment segment, Point point) {
        double a;
        a = (segment.p1.y - segment.p2.y) / (segment.p1.x - segment.p2.x);
        double b;
        a=-1/a;
        b=point.y-a*point.x;

        double x0 = point.x;
        double y0 = point.y;
        double r = segment.distance();

        double root = Math.sqrt(-y0*y0+(2*a*x0+2*b)*y0-a*a*x0*x0-2*a*b*x0+(a*a+1)*r*r-b*b);
        double x1 = -(root-a*y0-x0+a*b)/(a*a+1);
        double y1 = -(a*root-a*a*y0-a*x0-b)/(a*a+1);
        double x2 = (root+a*y0+x0-a*b)/(a*a+1);
        double y2 = (a*root+a*a*y0+a*x0+b)/(a*a+1);

        return new Segment[]{new Segment(point, new Point(x2, y2)), new Segment(point, new Point(x1, y1))};
//        Point p1 = new Point(point.x+(-(segment.getP2().x-segment.getP1().x)),
//                point.y +(segment.getP2().y-segment.getP1().y));
//        Point p2 = new Point(point.x-(-(segment.getP2().x-segment.getP1().x)),
//                point.y -(segment.getP2().y-segment.getP1().y));
//        return new Segment[]{new Segment(point,p1),new Segment(point,p2)};
    }
}
