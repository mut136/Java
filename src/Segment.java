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

    public double segmentLen() {
        return Math.hypot(p2.x - p1.x, p2.y - p1.y);
    }

    public String toSvg() {
        return String.format(Locale.ENGLISH, "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" />", p1.x, p1.y, p2.x, p2.y);
    }

    public static Segment[] perpendicural(Segment segment, Point point) {
//        double a = (seg.getP1().y - seg.getP2().y) / (seg.getP1().x - seg.getP2().x);
//        a = -(1 / a);
//        double b = point.y - a * point.x;
//        double r = seg.segmentLen();
//        double root = Math.sqrt(-Math.pow(point.y, 2) + (2 * a * point.x + 2 * b) * point.y - (Math.pow(a, 2) * Math.pow(point.x, 2)) -
//                2 * a * b * point.x + (Math.pow(a, 2) + 1) * Math.pow(r, 2) - Math.pow(b, 2));
//        double x, y, primeX, primeY;
//        x = -(root - a * point.y - point.x + a * b) / (Math.pow(a, 2) + 1);
//        y = -(a * root - Math.pow(a, 2) * point.y - a * point.x - b) / (Math.pow(a, 2) + 1);
//        primeX = (root + a * point.y + point.x - a * b) / (Math.pow(a, 2) + 1);
//        primeY = (a * root + Math.pow(a, 2) * point.y + a * point.x + b) / (Math.pow(a, 2) + 1);
//        return new Segment[]{new Segment(point, new Point(primeX, primeY)), new Segment(point, new Point(x, y))};
        Point p1 = new Point(point.x+(-(segment.getP2().x-segment.getP1().x)),
                point.y +(segment.getP2().y-segment.getP1().y));
        Point p2 = new Point(point.x-(-(segment.getP2().x-segment.getP1().x)),
                point.y -(segment.getP2().y-segment.getP1().y));
        return new Segment[]{new Segment(point,p1),new Segment(point,p2)};
    }
}
