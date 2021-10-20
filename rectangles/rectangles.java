package rectangles;

public class rectangles {
    public static void main(String[] args) {
        rectangle r = new rectangle(1.0, 1.0);
        System.out.println(r.getArea());
        System.out.println(r.getPerimeter());
        System.out.println(r.isSquare());
        System.out.println(r.isAreaEqualToPerimeter());
    }
}

class rectangle {
    private double length;
    private double width;

    public rectangle(double l, double w) {
        length = l;
        width = w;
    }
    public double getArea() {
        return length*width;
    }

    public double getPerimeter() {
        return (2*length) + (2*width);
    }

    public boolean isSquare() {
        if (length == width)
        return true;
        else
        return false;
    }

    public boolean isAreaEqualToPerimeter() {
        if (getPerimeter() == getArea())
        return true;
        else return false;
    }
}
