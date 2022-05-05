import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String args[]) throws FileNotFoundException, IOException {
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            myWriter.write("-----------------------------------------------------------\n");
            myWriter.write("KEY: 1 = path node  |  0 = non-path node  |  x = obstacle\n");
            myWriter.write("-----------------------------------------------------------\n");
            for(int i=-1; i<6; i++){
                if (i == -1) {
                    myWriter.write("No Obstacles:\n\n");
                } else if (i == 0) {
                    myWriter.write("Environment: Manhattan doesn't work but euclidean does\n\n");
                } else if (i == 1) {
                    myWriter.write("Environment: Only affects euclidean\n\n");
                } else if (i == 2) {
                    myWriter.write("Environment: Only affects manhattan\n\n");
                } else if (i == 3) {
                    myWriter.write("Environment: Euclean runtme should be longer\n\n");
                } else if (i == 4) {
                    myWriter.write("Environment: random obstacles\n\n");
                } else if (i == 5) {
                    myWriter.write("Environment: middle barrier\n\n");
                }

                int end =9;
                if(i==5)
                    end=0;
                
                Graph diagonalGrid = new Graph(10, 0, 0, 9, end, "Diagonal", i);
                Graph diagonalGridBFS = new Graph(10, 0, 0, 9, end, "Diagonal", i);
                Graph manhattanGrid = new Graph(10, 0, 0, 9,end, "Manhattan", i);
    
                // creates new Astar object using grid
                Astar astar = new Astar(manhattanGrid);
                AStarDiagonal eucl = new AStarDiagonal(diagonalGrid);

                myWriter.write("Manhattan:\n");

                if (astar.run() == 1) {
                    myWriter.write(manhattanGrid.result);
                    myWriter.write("Found\n");
                } else {
                    myWriter.write("Not Found\n");
                }
                myWriter.write(astar.result);
                myWriter.write("\n");

                myWriter.write("Diagonal:\n");
  
                if (eucl.run() == 1) {
                    myWriter.write(diagonalGrid.result);
                    myWriter.write("Found\n");
                } else {
                    myWriter.write("Not Found\n");
                }
                myWriter.write(eucl.result);
                myWriter.write("\n");

                myWriter.write("BFS:\n");

                double startTime = System.nanoTime();
    
                BFS bfs = new BFS(diagonalGridBFS);
                bfs.bfs();
                myWriter.write(diagonalGridBFS.result);
                
                double endTime = System.nanoTime();
                double duration2 = (endTime - startTime);
                myWriter.write(String.format("%.2fms\n", duration2 / 1_000_000));
                //System.out.format("%.2fms\n", duration2 / 1_000_000);
    
                myWriter.write("------------------------------------------------------\n");
                //System.out.println("------------------------------------------------------");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
