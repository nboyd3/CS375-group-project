public class Main {

    public static void main(String args[]) {

        for(int i=0; i<6; i++){
            int end =9;
            if(i==5)
                end=0;
            Graph diagonalGrid = new Graph(10, 0, 0, 9, end, "Diagonal", i);
            Graph manhattanGrid = new Graph(10, 0, 0, 9,end, "Manhattan", i);

            // creates new Astar object using grid
            Astar astar = new Astar(manhattanGrid);
            AStarDiagonal eucl = new AStarDiagonal(diagonalGrid);
            System.out.println("Manhattan:");
            // times the algorithm
            double startTime = System.nanoTime();
            astar.run();
            double endTime = System.nanoTime();
            double duration = (endTime - startTime);
            //System.out.format("%.2fms\n", duration / 1_000_000);
            System.out.println("Diagonal:");
            startTime = System.nanoTime();
            eucl.run();
            endTime = System.nanoTime();
            duration = (endTime - startTime);
            //System.out.format("%.2fms\n", duration / 1_000_000);
            System.out.println("------------------------------------------------------");

            System.out.format("%.2fms\n", duration / 1_000_000);
            System.out.println("For BFS:\n");
            startTime = System.nanoTime();

            BFS bfs = new BFS(diagonalGrid);
            bfs.bfs();
    
            endTime = System.nanoTime();
            double duration2 = (endTime - startTime);
            System.out.format("%.2fms\n", duration2 / 1_000_000);
            }
    }
}
