public class Main {

    public static void main(String args[]) {
        Graph grid = new Graph(10, 0, 0, 9, 9);
        Astar astar = new Astar(grid);

        double startTime = System.nanoTime();
        astar.run();
        double endTime = System.nanoTime();

        double duration = (endTime - startTime);

        System.out.format("%.2fms\n", duration / 1_000_000);
    }
}