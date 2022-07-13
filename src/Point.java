public class Point {

    public final int x;
    public final int y;

    public Point(int x, int y) {

        assert x >= 0 && x <= 2 && y >= 0 && y <= 2;

        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point: " + x + " - " + y;
    }
}
