package exercise;

import java.util.Map;

// BEGIN
public class Circle {
    Point point;
    int r;

    public Circle(Point point, int r) {
        this.point = point;
        this.r = r;
    }
    public int getRadius() {
        return this.r;
    }
    public double getSquare() throws NegativeRadiusException {
        if (this.r < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return Math.PI * r * r;
    }
}
// END
