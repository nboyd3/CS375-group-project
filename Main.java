public class Main {

    public static void main(String args[]) {

        // creates new graph
        Graph grid = new Graph(10, 0, 0, 9, 9);

        // creates new Astar object using grid
        Astar astar = new Astar(grid);

        // times the algorithm
        double startTime = System.nanoTime();
        astar.run();
        double endTime = System.nanoTime();

        double duration = (endTime - startTime);

        System.out.format("%.2fms\n", duration / 1_000_000);

        System.out.println("For BFS:\n");
        startTime = System.nanoTime();

        BFS bfs = new BFS(grid);
        bfs.bfs();

        endTime = System.nanoTime();
        double duration2 = (endTime - startTime);
        System.out.format("%.2fms\n", duration2 / 1_000_000);
    }
}