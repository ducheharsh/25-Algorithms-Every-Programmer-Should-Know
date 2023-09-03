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
