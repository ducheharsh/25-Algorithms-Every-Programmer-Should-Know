public class FloodFill {

    public static void floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int oldColor = image[sr][sc];

        if (oldColor != newColor) {
            dfs(image, sr, sc, oldColor, newColor, rows, cols);
        }
    }

    public static void dfs(int[][] image, int row, int col, int oldColor, int newColor, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != oldColor) {
            return;
        }

        image[row][col] = newColor;

        dfs(image, row - 1, col, oldColor, newColor, rows, cols);
        dfs(image, row + 1, col, oldColor, newColor, rows, cols);
        dfs(image, row, col - 1, oldColor, newColor, rows, cols);
        dfs(image, row, col + 1, oldColor, newColor, rows, cols);
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };

        int sr = 1, sc = 1, newColor = 2;

        floodFill(image, sr, sc, newColor);

        System.out.println("Flood-Filled Image:");
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}

/*The provided Java code implements the flood fill algorithm to change the color of a connected region in a 2D image. It starts from a given pixel and recursively fills adjacent pixels of the same original color with a new color. Here's a short description:

The `floodFill` method:
- Takes an image represented as a 2D array, a starting pixel (sr, sc), and a new color.
- Checks if the old color at the starting pixel is different from the new color.
- If they are different, it calls the `dfs` method to perform the flood fill.

The `dfs` method:
- Recursively explores neighboring pixels in four directions (up, down, left, right).
- Changes the color of each visited pixel to the new color.
- Stops when it encounters out-of-bounds pixels or pixels with colors different from the old color.

In the `main` method:
- An example image is provided as a 2D array.
- A starting point (sr, sc) and a new color are specified.
- The `floodFill` method is called to fill the connected region starting from the specified point with the new color.
- The resulting image is printed to the console.*/
