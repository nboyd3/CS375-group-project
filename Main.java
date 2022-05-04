public class Main {

    public static void main(String args[]) {
        
        Graph diagonalGrid = new Graph(50, 0, 0, 49, 49, "Diagonal");
        Graph manhattanGrid = new Graph(50, 0, 0, 49, 49, "Manhattan");

        // creates new Astar object using grid
        Astar astar = new Astar(manhattanGrid);
        AStarDiagonal eucl = new AStarDiagonal(diagonalGrid);

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