import java.util.*;

public class LeesAlgorithm {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1; // No path possible
        }

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1; // Mark the start cell as visited

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                if (x == n - 1 && y == n - 1) {
                    return steps;
                }

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                        queue.offer(new int[]{newX, newY});
                        grid[newX][newY] = 1; // Mark the cell as visited
                    }
                }
            }
        }

        return -1; // No path found
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {1, 1, 0}
        };

        int shortestPath = shortestPathBinaryMatrix(grid);

        System.out.println("Shortest Path Length: " + shortestPath);
    }
}

/*The provided Java code implements Lee's Algorithm to find the shortest path in a binary matrix, where 0 represents an open cell that can be traversed, and 1 represents a blocked cell. Here's a short description:

1. The `shortestPathBinaryMatrix` method:
   - Takes a 2D binary grid as input.
   - Checks if there is a valid path from the top-left corner (0,0) to the bottom-right corner (n-1,n-1), where n is the size of the grid.
   - If either the starting or ending cell is blocked (contains a 1), it returns -1, indicating that no path is possible.

2. The algorithm uses a queue to perform a breadth-first search (BFS) traversal of the grid:
   - It starts from the top-left corner and initializes a step counter.
   - The grid is modified to mark visited cells (changing 0 to 1) to avoid revisiting them.

3. In a loop, the algorithm iteratively explores neighboring cells:
   - For each cell in the queue, it checks if it has reached the bottom-right corner (n-1,n-1). If yes, it returns the step count as the shortest path length.
   - Otherwise, it explores adjacent cells in eight possible directions (up, down, left, right, and diagonals) if they are within bounds and unvisited (have a 0).

4. If the queue becomes empty without finding a path to the destination, the method returns -1, indicating that no valid path exists.

5. In the `main` method:
   - An example binary grid is provided.
   - The `shortestPathBinaryMatrix` method is called to find the shortest path length.
   - The result is printed to the console.

This code efficiently finds the shortest path through a binary matrix, considering both blocked and open cells, and returns the shortest path length or -1 if no path exists.*/
