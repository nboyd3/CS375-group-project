public class Main {

    public static void main(String args[]) {
        
        Graph eucledianGrid = new Graph(50, 0, 0, 49, 49, "Eucledian");
        Graph manhattanGrid = new Graph(50, 0, 0, 49, 49, "Manhattan");

        // creates new Astar object using grid
        Astar astar = new Astar(manhattanGrid);
        AStarEucl eucl = new AStarEucl(eucledianGrid);

        // times the algorithm
        double startTime = System.nanoTime();
        astar.run();
        double endTime = System.nanoTime();
        double duration = (endTime - startTime);
        //System.out.format("%.2fms\n", duration / 1_000_000);
        
        startTime = System.nanoTime();
        eucl.run();
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        //System.out.format("%.2fms\n", duration / 1_000_000);
    }
}