import java.util.Set;

public class Node {
    private int f;
    private int g;
    private int h;

    public Node(int f, int g, int h) {
        this.f = f;
        this.g = g;
        this.h = h;
    }

    public void setF(int f) {
        this.f = f;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return f;
    }

    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }

}
