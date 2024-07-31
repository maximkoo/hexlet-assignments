package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private double floorCount;

    public Cottage(double area, double floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        //return String.valueOf(floorCount) + " этажный коттедж площадью "+area+" метров";
        return String.valueOf((int) floorCount) + " этажный коттедж площадью " + area + " метров";
    }

    @Override
    public int compareTo(Home another) {
        if (this.getArea() > another.getArea()) {
            return 1;
        } else if (this.getArea() == another.getArea()) {
            return 0;
        } else {
            return -1;
        }
    }
}
// END
