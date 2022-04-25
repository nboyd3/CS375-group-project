public class Graph {
    
    private int deminsion;
    private int sx;
    private int sy;
    private int ex;
    private int ey;

    private Node graph[][];

    public Graph(int deminsion, int sx, int sy, int ex, int ey) {
        this.deminsion = deminsion;
        this.sx = sx;
        this.sy = sy;
        this.ex = ex;
        this.ey = ey;
        graph = new Node[deminsion][deminsion];

        for (int i = 0; i < deminsion; i++) {
            for (int j = 0; j < deminsion; j++) {
                graph[i][j] = new Node(i, j);
            }
        }

        graph[sx][sy].setObstacle(false);
        graph[ex][ey].setObstacle(false);

        for (int i = 0; i < deminsion; i++) {
            for (int j = 0; j < deminsion; j++) {
                graph[i][j].setNeighbors(graph, deminsion);
            }
        }

    }

    public int getDeminsion() {
        return deminsion;
    }

    public int getSx() {
        return sx;
    }

    public int getSy() {
        return sy;
    }

    public int getEx() {
        return ex;
    }

    public int getEy() {
        return ey;
    }

    public Node[][] getGraph() {
        return graph;
    }

    public Node getStart() {
        return graph[sx][sy];
    }

    public Node getEnd() {
        return graph[ex][ey];
    }

    public void printGraph() {
        for (int i = 0; i < deminsion; i++) {
            for (int j = 0; j < deminsion; j++) {
                if (graph[i][j].getObstacle()) {
                    System.out.print("x ");
                } else {
                    System.out.print(graph[i][j].getPath() + " ");
                }
            }
            System.out.println();
        }
    }
 
}
