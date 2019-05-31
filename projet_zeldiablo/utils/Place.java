package utils;

public class Place {

    private int x;

    private int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void incrementerX(int dx) {
        this.x += dx;
    }

    public void incrementerY(int dy) {
        this.y += dy;
    }
}
