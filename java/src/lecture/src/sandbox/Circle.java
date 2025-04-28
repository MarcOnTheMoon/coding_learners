package sandbox;

public class Circle {
    double x, y;
    double radius;

    Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    Circle() {
        this(0.0, 0.0, 1.0);
    }

    Circle(double radius) {
        this(0.0, 0.0, radius);
    }

    Circle(Circle other) {
        this(other.x, other.y, other.radius);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius >= 0.0)
            this.radius = radius;
    }
}
