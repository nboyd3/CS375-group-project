public class Graph {
    
    private int deminsion;
    private int sx;
    private int sy;
    private int ex;
    private int ey;
    private String type;

    private Node graph[][];

    public Graph(int deminsion, int sx, int sy, int ex, int ey, String type) {
        this.deminsion = deminsion; // graph deminsion (square)
        this.sx = sx; // start x
        this.sy = sy; // start y
        this.ex = ex; // end x
        this.ey = ey; // end y
        this.type=type;
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



        //Set Obstracles like this
        //graph[0][1].setObstacle(true);
        // graph[4][4].setObstacle(true);
        // graph[4][3].setObstacle(true);
        // graph[3][4].setObstacle(true);

        /*Environment: Manhattan doesn't work but euclidean does*/
        // for(int i=0; i<10; i++)
        //         graph[i][9-i].setObstacle(true);
        // /*Environment: Only affects euclidean*/
        //     graph[4][4].setObstacle(true);
        //     graph[4][3].setObstacle(true);
        //     graph[3][4].setObstacle(true);
        // /*Environment: Only affects manhattan*/
        //     for(int i=2; i<10; i++)
        //         graph[1][i].setObstacle(true);
        
        /*Environment: Euclean runtme should be much longer*/
        // for(int i=1; i<50; i++)
        //     for(int j=0; j<49; j++)
        //         graph[i][j].setObstacle(true);
        // for(int i=0; i<48; i++)
        //     graph[i][i].setObstacle(false);
        /*Environment: random obstacles*/
        // for(int i=0; i<50-1; i++){
        //     int rand1 = (int)(Math.random() * 50 );
        //     int rand2 = (int)(Math.random() * 50 );
        //     graph[35][i].setObstacle(true);
        // }
        
           
        // get neighbors for all nodes
        if(type=="Eucledian"){
            for (int i = 0; i < deminsion; i++) {
                for (int j = 0; j < deminsion; j++) {
                    graph[i][j].setNeighborsEucl(graph, deminsion);
                }
            }
        }
        if(type=="Manhattan"){
            for (int i = 0; i < deminsion; i++) {
                for (int j = 0; j < deminsion; j++) {
                    graph[i][j].setNeighborsManhattan(graph, deminsion);
                }
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
