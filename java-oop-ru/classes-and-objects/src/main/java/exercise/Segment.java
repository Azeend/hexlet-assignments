package exercise;

// BEGIN
public class Segment {
    private Point a;
    private Point b;

    public Segment(Point a, Point b) {
        this.a = a;
        this.b = b;
    }
    public Point getBeginPoint() {
        return a;
    }
    public Point getEndPoint() {
        return b;
    }

    public Point getMidPoint() {
        int intBegin = (a.getX() + b.getX())/ 2;
        int intEnd = (a.getY() + b.getY())/2;
        return new Point(intBegin, intEnd);
    }
}
// END
