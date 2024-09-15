package exercise;

// BEGIN
public class Circle {
    private Point point;
    private Integer radius;

    public Circle(Point point, Integer radius) {
        this.point = point;
        this.radius = radius;
    }

    public Integer getRadius() {
        return radius;
    }

    public Double getSquare() throws NegativeRadiusException {
        if (getRadius() < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return Math.PI * radius * radius;
    }
}
// END
