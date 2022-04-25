public class Graph {
    
    private int deminsion;
    private int sx;
    private int sy;
    private int ex;
    private int ey;

    private Node graph[][];

    public Graph(int deminsion, int sx, int sy, int ex, int ey) {
        this.deminsion = deminsion; // graph deminsion (square)
        this.sx = sx; // start x
        this.sy = sy; // start y
        this.ex = ex; // end x
        this.ey = ey; // end y
        graph = new Node[deminsion][deminsion]; // 2d Node array

        // fill graph with Nodes
        for (int i = 0; i < deminsion; i++) {
            for (int j = 0; j < deminsion; j++) {
                graph[i][j] = new Node(i, j);
            }
        }

        // make sure the start and end are not set to obstacles
        graph[sx][sy].setObstacle(false);
        graph[ex][ey].setObstacle(false);

        // get neighbors for all nodes
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
                    if (graph[i][j].getPath()) {
                        System.out.print(1 + " ");
                    } else {
                        System.out.print(0 + " ");
                    }
                }
            }
            System.out.println();
        }
    }
 
}
