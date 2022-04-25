import java.util.ArrayList;

public class Astar {

    private ArrayList<Node> open = new ArrayList<>();
    private ArrayList<Node> closed = new ArrayList<>();
    Graph graph;

    public Astar(Graph graph) {
        this.graph = graph;
    }

    private int heristic(Node n1, Node n2) {
        int ys = Math.abs(n1.getY() - n2.getY());
        int xs = Math.abs(n1.getX() - n2.getX());
        return ys + xs;
    }

    private void findPath() {
        Node curr = graph.getEnd();
        while (curr.getCameFrom() != null) {
            curr.setPath(true);
            curr = curr.getCameFrom();
        }
        graph.getStart().setPath(true);
        graph.printGraph();
    }

    public int run() {

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
                    int tempG = curr.getG() + 1;

                    if (open.contains(neighbor)) {
                         if (tempG < neighbor.getG()) {
                             neighbor.setG(tempG);
                         }
                    } else {
                        neighbor.setG(tempG);
                        open.add(neighbor);
                    }

                    neighbor.setH((int) heristic(neighbor, graph.getEnd()));
                    neighbor.setF(neighbor.getG() + neighbor.getH());
                    neighbor.setCameFrom(curr);
                    
                }
            }

            if (low == graph.getEnd()) {
                findPath();
                System.out.println("Found!");
                return 0;
            }
        }

        System.out.println("Not Found :(");
        return 0;
    }

}
