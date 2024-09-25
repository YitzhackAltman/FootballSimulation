package FootbalSimulator.Dependecies;

public class Position {
    public double x, y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        x = 0;
        y = 0;
    }


    public static Position fromAngle(double angel) {
        return new Position(Math.cos(angel), Math.sin(angel));
    }

    public Position sub(final Position p) {
        return new Position(this.x - p.x, this.y - p.y);
    }
    public Position add(final Position p) {
        return new Position(this.x + p.x, this.y + p.y);
    }

    public Position div(final Position p) {
        return new Position(this.x / p.x, this.y / p.y);
    }

    private double length() {
        return  Math.sqrt((this.x*this.x + this.y*this.y));
    }

    public double distanceTo(final Position p) {
        return p.sub(this).length();
    }

    public Position scale(double num) {
        return new Position(this.x * num, this.y * num);
    }

    public Position rotate90() {
        return new Position(-this.y, this.x);
    }

    public Position lerp(Position p, double t) {
        return p.sub(this).scale(t).add(this);
    }

    public Position negative(Position p) { return new Position(-this.x, -this.y); }

    public Position normalize() {
        final double length = length();
        if(length == 0) return new Position();
        return new Position(this.x / length, this.y / length);
    }

    public Position copy() {
        return new Position(this.x, this.y);
    }

    public Position mul(final Position p) {
        return new Position(this.x * p.x, this.y * p.y);
    }


    public String toString() {
        return "pos("  + x + " ," + y +")";
    }
}
