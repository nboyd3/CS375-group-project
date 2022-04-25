import java.util.ArrayList;

public class Node {
    private int x;
    private int y;
    private int f;
    private int g; // movement cost from start to node
    private int h; // estimated movement cost from node to finish
    private boolean obstacle;
    private ArrayList<Node> neighbors = new ArrayList<>();
    private Node cameFrom;
    private int path;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.obstacle = false;
        this.cameFrom = null;
        this.path = 0;
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

    public void setNeighbors(Node[][] g, int d) {
        if (x > 0) {
            neighbors.add(g[x - 1][y]);
        }
        if (y > 0) {
            neighbors.add(g[x][y - 1]);
        }
        if (x < d - 1) {
            neighbors.add(g[x + 1][y]);
        }
        if (y < d - 1) {
            neighbors.add(g[x][y + 1]);
        }
    }

    public void setCameFrom(Node cameFrom) {
        this.cameFrom = cameFrom;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public void setObstacle(boolean obstacle) {
        this.obstacle = obstacle;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }

    public Node getCameFrom() {
        return cameFrom;
    }

    public int getPath() {
        return path;
    }

    public boolean getObstacle() {
        return obstacle;
    }
}
