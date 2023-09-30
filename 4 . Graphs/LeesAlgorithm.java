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
/*This Java program implements Lee's Algorithm to find the shortest path in a binary matrix. The matrix represents a grid where 0 denotes an open cell, and 1 denotes a blocked cell. The algorithm is applied to a grid with the starting point at the top-left corner (0, 0) and the destination at the bottom-right corner (n-1, n-1). The main components are as follows:

1. **`shortestPathBinaryMatrix` method:**
   - Takes a 2D array (`grid`) as input, where 0 represents an open cell, and 1 represents a blocked cell.
   - Initializes a queue for BFS traversal and a 2D array (`directions`) to define possible movement directions (including diagonal movements).
   - Marks the start cell as visited (grid[0][0] = 1) and adds it to the queue.
   - Performs BFS traversal while updating the distance (number of steps) from the start.
   - If the destination cell (bottom-right) is reached, returns the shortest path length. Otherwise, returns -1 if no path is found.

2. **`main` method:**
   - Creates a binary matrix representing a grid.
   - Calls `shortestPathBinaryMatrix` with the grid and prints the shortest path length.

3. **Explanation:**
   - The algorithm uses BFS to explore possible paths in the matrix.
   - It iteratively visits neighboring cells, marking them as visited and enqueueing them if they are valid and not blocked.
   - The process continues until the destination is reached or no more cells are reachable.
   - The final result is the shortest path length from the start to the destination or -1 if no path exists.

In the provided example, the grid has a start at the top-left (0, 0) and a destination at the bottom-right (2, 2). The blocked cells are represented by 1, and the open cells are represented by 0. The output would be the length of the shortest path, considering valid moves in all directions, or -1 if no path is possible.*/
