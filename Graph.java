public class Graph {
    
    private int deminsion;

    private Node graph[][];

    public Graph(int deminsion) {
        this.deminsion = deminsion;
        graph = new Node[deminsion][deminsion];

        for (int i = 0; i < deminsion; i++) {
            for (int j = 0; j < deminsion; j++) {
                graph[i][j] = new Node(0, 0, 0);
            }
        }

    }

    public int getDeminsion() {
        return deminsion;
    }

    public Node[][] getGraph() {
        return graph;
    }

    public void printGraph() {
        for (int i = 0; i < deminsion; i++) {
            for (int j = 0; j < deminsion; j++) {
                System.out.print(graph[i][j].getF() + " ");
            }
            System.out.println();
        }
    }

}
