package DataStructure;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by AiYeSus on 12/18/2017.
 *
 * Input:
 3 4 1 2 8 6
 6 1 8 2 7 4
 5 9 3 9 9 5
 8 4 1 3 2 6
 3 7 2 8 6 4
 Output:
 Yes 16 [1 2 3 4 4 5]

 Sample 2: (6X5 matrix normal flow)
 Input:
 3 4 1 2 8 6
 6 1 8 2 7 4
 5 9 3 9 9 5
 8 4 1 3 2 6
 3 7 2 1 2 3

 Output:
 Yes 11 [1 2 1 5 4 5]

 Sample 3: (5X3 matrix with no path <50)
 Input:
 19 10 19 10 19
 21 23 20 19 12
 20 12 20 11 10

 Output:
 No 48 [1 1 1]

 Sample 4: (1X5 matrix)
 Input:
 5 8 5 3 5

 Output:
 Yes 26 [1 1 1 1 1]

 0 9 6 5 3
 0 0 0 0 0
 0 2 0 4 0
 0 0 0 0 0
 0 0 0 0 0
 Enter the source
 1
 Enter the destination
 4
 The Shorted Path from 1 to 4 is:
 1 to 4 is 5
 */

public class Dijkstra_ShortestPath
{
    private int          distances[];
    private Set<Integer> settled;
    private Set<Integer> unsettled;
    private int          rows, columns;
    private int          adjacencyMatrix[][];

    public Dijkstra_ShortestPath(int nrow, int ncol)
    {
        this.rows = nrow;
        distances = new int[nrow + 1];
        settled = new HashSet<Integer>();
        unsettled = new HashSet<Integer>();
        adjacencyMatrix = new int[rows][columns];
    }

    public void dijkstra_algorithm(int adjacency_matrix[][], int source) {
        int evaluationNode;
        for (int i = 1; i <= rows; i++)
            for (int j = 1; j <= columns; j++)
                adjacencyMatrix[i][j] = adjacency_matrix[i][j];

        for (int i = 1; i <= rows; i++)
        {
            distances[i] = Integer.MAX_VALUE;
        }

        unsettled.add(source);
        distances[source] = 0;
        while (!unsettled.isEmpty())
        {
            evaluationNode = getNodeWithMinimumDistanceFromUnsettled();
            unsettled.remove(evaluationNode);
            settled.add(evaluationNode);
            evaluateNeighbours(evaluationNode);
        }
    }

    private int getNodeWithMinimumDistanceFromUnsettled() {
        int min;
        int node = 0;

        Iterator<Integer> iterator = unsettled.iterator();
        node = iterator.next();
        min = distances[node];
        for (int i = 1; i <= distances.length; i++) {
            if (unsettled.contains(i))
            {
                if (distances[i] <= min)
                {
                    min = distances[i];
                    node = i;
                }
            }
        }
        return node;
    }

    private void evaluateNeighbours(int evaluationNode) {
        int edgeDistance = -1;
        int newDistance = -1;

        for (int destinationNode = 1; destinationNode <= rows; destinationNode++) {
            if (!settled.contains(destinationNode)) {
                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE) {
                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
                    newDistance = distances[evaluationNode] + edgeDistance;
                    if (newDistance < distances[destinationNode]) {
                        distances[destinationNode] = newDistance;
                    }
                    unsettled.add(destinationNode);
                }
            }
        }
    }

    public static void main(String... arg) {
        int adjacency_matrix[][];
        int nRow, nCol;
        int source = 0, destination = 0;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter the number of row col in matrix");
            nRow = scan.nextInt();
            nCol = scan.nextInt();
            adjacency_matrix = new int[nRow][nCol];

            System.out.println("Enter the Weighted Matrix for the graph");
            for (int i = 0; i < nRow; i++) {
                for (int j = 0; j < nCol; j++) {
                    adjacency_matrix[i][j] = scan.nextInt();
                    if (i == j) {
                        adjacency_matrix[i][j] = 0;
                        continue;
                    }
                    if (adjacency_matrix[i][j] == 0) {
                        adjacency_matrix[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            System.out.println("Enter the source ");
            source = scan.nextInt();

            System.out.println("Enter the destination ");
            destination = scan.nextInt();

            Dijkstra_ShortestPath dijkstrasAlgorithm = new Dijkstra_ShortestPath(nRow, nCol);
            dijkstrasAlgorithm.dijkstra_algorithm(adjacency_matrix, source);

            System.out.println("The Shorted Path from " + source + " to " + destination + " is: ");
            for (int i = 1; i <= dijkstrasAlgorithm.distances.length - 1; i++) {
                if (i == destination)
                    System.out.println(source + " to " + i + " is "
                            + dijkstrasAlgorithm.distances[i]);
            }
        } catch (InputMismatchException inputMismatch) {
            System.out.println("Wrong Input Format");
        }
        scan.close();
    }
}