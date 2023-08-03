import java.util.Arrays;

public class ChocolateDistribution {

    private static void chocolateDistributionProblem() {
        int arr[] = { 7, 3, 2, 4, 9, 12, 56 };
        int students = 3;

        if (arr.length == 0 || students == 0) {
            System.out.println("Data Invalid.");
            return;
        }

        if (arr.length < students) {
            System.out.println("More Students Than Pack Of Chocolates.");
            return;
        }

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.length - students; i++) {
            int currDiff = arr[i + students - 1] - arr[i];
            minDiff = Math.min(minDiff, currDiff);
        }

        System.out.println("Minimum Difference In Chocolate Distribution Is : " + minDiff);
    }

    public static void main(String[] args) {
        chocolateDistributionProblem();
    }
}
