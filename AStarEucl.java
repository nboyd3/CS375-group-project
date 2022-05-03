import java.util.ArrayList;

public class AStarEucl {

    private ArrayList<Node> open = new ArrayList<>();
    private ArrayList<Node> closed = new ArrayList<>();
    Graph graph;

    public AStarEucl(Graph graph) {
        this.graph = graph;
    }

    private double heristic(Node n1, Node n2) {
        double ys = Math.abs(n1.getY() - n2.getY());
        double xs = Math.abs(n1.getX() - n2.getX());
        //return ys + xs;
        return Math.sqrt(ys*ys+xs*xs);
    }

    private void findPath() {
        Node curr = graph.getEnd();
        while (curr.getCameFrom() != null) {
            curr.setPath(true);
           // System.out.println(curr.getX()+","+curr.getY());
            curr = curr.getCameFrom();
        }
        graph.getStart().setPath(true);
        graph.printGraph();
        System.out.format("%.2f units\n",graph.getEnd().getG());
    }

    public int run() {

        open.add(graph.getStart());
        while (open.size() > 0) {

            Node low = open.get(0);
            for (Node n : open) {
                //System.out.print(n.getX()+","+n.getY()+": ");
                if (n.getF() < low.getF()) {
                    low = n;
                }
            }
            //System.out.println();
            Node curr = low;

            closed.add(curr);
            open.remove(curr);
            //if(curr!=graph.getStart())
                //System.out.println(curr.getF()+": "+curr.getCameFrom().getX()+curr.getCameFrom().getY());
            ArrayList<Node> neighbors = curr.getNeighbors();
            for (int i = 0; i < neighbors.size(); i++) {
                Node neighbor = neighbors.get(i);
                if (!closed.contains(neighbor) && !neighbor.getObstacle()) {
                    double tempG = curr.getG() + 1;
                    if(neighbor.getX()!=curr.getX()&&neighbor.getY()!=curr.getY())
                        tempG=curr.getG()+1.44;
                    if (open.contains(neighbor)) {
                         if (tempG < neighbor.getG()) {
                            neighbor.setG(tempG);
                            neighbor.setH((double) heristic(neighbor, graph.getEnd()));
                            neighbor.setF(neighbor.getG() + neighbor.getH());
                            neighbor.setCameFrom(curr);
                         }
                    } else {
                        neighbor.setG(tempG);
                        open.add(neighbor);
                        //System.out.println("Quagmire");
                        neighbor.setH((double) heristic(neighbor, graph.getEnd()));
                        neighbor.setF(neighbor.getG() + neighbor.getH());
                        neighbor.setCameFrom(curr);
                    }
                    //
                    
                    //System.out.println(curr.getX()+","+curr.getY()+": "+neighbor.getX()+","+neighbor.getY()+":: "+neighbor.getF());
                    
                }
                //System.out.println(curr.getX()+","+curr.getY()+": "+i);
            }
            // graph.printGraph();
            // System.out.println("--------------------------------------");
            if (low == graph.getEnd()) {
                findPath();
                System.out.println("Found!");
                return 0;
            }
            //System.out.println("-----------");
        }

        System.out.println("Not Found :(");
        return 0;
    }

}
