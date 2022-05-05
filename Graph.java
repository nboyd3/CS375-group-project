public class Graph {
    
    private int deminsion;
    private int sx;
    private int sy;
    private int ex;
    private int ey;
    private String type;
    private int environment;
    public String result;

    private Node graph[][];

    public Graph(int deminsion, int sx, int sy, int ex, int ey, String type, int environment) {
        this.deminsion = deminsion; // graph deminsion (square)
        this.sx = sx; // start x
        this.sy = sy; // start y
        this.ex = ex; // end x
        this.ey = ey; // end y
        this.type=type;
        this.environment=environment;
        graph = new Node[deminsion][deminsion]; // 2d Node array
        this.result = "";

        // fill graph with Nodes
        for (int i = 0; i < deminsion; i++) {
            for (int j = 0; j < deminsion; j++) {
                graph[i][j] = new Node(i, j);
            }
        }

        // make sure the start and end are not set to obstacles
        



        //Set Obstracles like this
        //graph[0][1].setObstacle(true);
        // graph[4][4].setObstacle(true);
        // graph[4][3].setObstacle(true);
        // graph[3][4].setObstacle(true);

        /*Environment: Manhattan doesn't work but euclidean does*/
        

        if(environment==0){
            //if(type=="Diagonal")
            //result += "Environment: Manhattan doesn't work but euclidean does\n";
            //System.out.println("Environment: Manhattan doesn't work but euclidean does");
            for(int i=0; i<deminsion; i++)
                graph[i][deminsion-1-i].setObstacle(true);
        }
        
        // /*Environment: Only affects euclidean*/
        if(environment==1){
            //if(type=="Diagonal")
            //result += "Environment: Only affects euclidean\n";
            //System.out.println("Environment: Only affects euclidean");
            graph[4][4].setObstacle(true);
            graph[4][3].setObstacle(true);
            graph[3][4].setObstacle(true);
        }    
        // /*Environment: Only affects manhattan*/
        if(environment==2){
            //if(type=="Diagonal")
            //result += "Environment: Only affects manhattan\n";
            //System.out.println("Environment: Only affects manhattan");
            for(int i=2; i<deminsion; i++)
                graph[1][i].setObstacle(true);
        }
      
        
        /*Environment: Euclean runtme should be much longer*/
        if(environment==3){
            //if(type=="Diagonal")
            //System.out.println("Environment: Euclean runtme should be much longer");
            for(int i=1; i<deminsion; i++)
                for(int j=0; j<deminsion-1; j++)
                    graph[i][j].setObstacle(true);
            for(int i=0; i<deminsion-2; i++)
                graph[i][i].setObstacle(false);
        }
        
        /*Environment: random obstacles*/
        if(environment==4){
            //if(type=="Diagonal")
            //System.out.println("Environment: random obstacles");
            for(int i=0; i<10; i++){
                int rand1 = (int)(Math.random() * deminsion );
                int rand2 = (int)(Math.random() * deminsion );
                graph[rand1][rand2].setObstacle(true);
            }
        }
         
        if(environment==5){
            //if(type=="Diagonal")
            //System.out.println("Environment: middle barrier");
            for(int i=0; i<deminsion-1; i++){
                graph[deminsion/2][i].setObstacle(true);
            }
        }

        graph[sx][sy].setObstacle(false);
        graph[ex][ey].setObstacle(false);
        
           
        // get neighbors for all nodes
        if(type=="Diagonal"){
            for (int i = 0; i < deminsion; i++) {
                for (int j = 0; j < deminsion; j++) {
                    graph[i][j].setNeighborsDiag(graph, deminsion);
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
                    //System.out.print("x ");
                    result += "x ";
                } else {
                    if (graph[i][j].getPath()) {
                        //System.out.print(1 + " ");
                        result += "1 ";
                    } else {
                        //System.out.print(0 + " ");
                        result += "0 ";
                    }
                }
            }
            //System.out.println();
            result += "\n";
        }
    }
 
}
