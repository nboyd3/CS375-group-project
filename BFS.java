import java.util.*;
import java.util.ArrayList;

public class BFS {

    Node start, end;
    Graph graph;
    
    public BFS(Graph graph){
        this.start = graph.getStart();
        this.end = graph.getEnd();
        this.graph = graph;
    }

    public void bfs(){
        //Create queue
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
        trace_route();
    }

    private void trace_route(){
        Node node = end;
        List<Node> route = new ArrayList<>();
        while(node != null){
            route.add(node);
            node = node.prev;
        }
        Collections.reverse(route);
        graph.printGraph();
        }    
        
}