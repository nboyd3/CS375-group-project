import java.util.*;
import java.util.ArrayList;

public class BFS {

    Node start, end;
    Graph graph;
    String result;
    double length;
    
    public BFS(Graph graph){
        this.start = graph.getStart();
        this.end = graph.getEnd();
        this.graph = graph;
        this.result = "";
        this.length = 0;
    }

    public void bfs(){
        //Create queue
        double startTime = System.nanoTime();
        Queue<Node> queue = new LinkedList<>();

        start.visited = true;
        queue.add(start);
            while(!queue.isEmpty()){
        Node current_node = queue.poll();

        for(Node node: current_node.neighbors){
            if(!node.visited && !node.getObstacle()){
            node.visited =true;
            queue.add(node);
            //update its precedings nodes
            node.prev = current_node;
            if(node==end){
                queue.clear();
                break;
            }
            }
        }
        }
        double endTime = System.nanoTime();
        double duration = (endTime - startTime);
        result += String.format("%.3fms\n", duration / 1_000_000);
        trace_route();
    }

    private void trace_route(){
        Node node = end;
        List<Node> route = new ArrayList<>();
        while(node != null){
            route.add(node);
            if (node.prev != null) {
                if (node.getX() != node.prev.getX() && node.getY() != node.prev.getY()) {
                    length += 1.44;
                } else {
                    length++;
                }
            }
            node.setPath(true);
            node = node.prev;
        }
        Collections.reverse(route);
        graph.printGraph();
        }    
        
}