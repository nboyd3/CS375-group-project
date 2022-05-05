import java.util.ArrayList;

public class AStarDiagonal {

    private ArrayList<Node> open = new ArrayList<>();
    private ArrayList<Node> closed = new ArrayList<>();
    Graph graph;
    String result;

    public AStarDiagonal(Graph graph) {
        this.graph = graph;
        this.result = "";
    }

    private double heristic(Node n1, Node n2) {
        double ys = Math.abs(n1.getY() - n2.getY());
        double xs = Math.abs(n1.getX() - n2.getX());
        //return ys + xs;
        return (xs+ys)+(1.44-2)*Math.min(xs, ys);
        //return Math.sqrt(ys*ys+xs*xs);
    }

    private void findPath() {
        Node curr = graph.getEnd();
        while (curr.getCameFrom() != null) {
            curr.setPath(true);
            curr = curr.getCameFrom();
        }
        graph.getStart().setPath(true);
        graph.printGraph();
        //System.out.format("%.2f units\n",graph.getEnd().getG());
        result += String.format("%.2f units\n",graph.getEnd().getG());
    }

    public int run() {
        double startTime = System.nanoTime();
        open.add(graph.getStart());
        while (open.size() > 0) {

            Node low = open.get(0);
            for (Node n : open) {
                if (n.getF() < low.getF()) {
                    low = n;
                }
            }
            Node curr = low;

            closed.add(curr);
            open.remove(curr);
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
                        neighbor.setH((double) heristic(neighbor, graph.getEnd()));
                        neighbor.setF(neighbor.getG() + neighbor.getH());
                        neighbor.setCameFrom(curr);
                    }                    

                }
            }
            if (low == graph.getEnd()) {
                double endTime = System.nanoTime();
                double duration = (endTime - startTime);
                findPath();
                //System.out.println("Found!");
                //System.out.format("%.3fms\n", duration / 1_000_000);
                result += String.format("%.3fms\n", duration / 1_000_000);
                return 1;
            }
        }

        double endTime = System.nanoTime();
        double duration = (endTime - startTime);
        //System.out.println("Not Found :(");
        //System.out.format("%.3fms\n", duration / 1_000_000);
        result += String.format("%.3fms\n", duration / 1_000_000);
        return 0;
    }

}
