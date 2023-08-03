import java.util.Arrays;

public class ChocolateDistribution {
    
    private static void ChocolateDistributionProblem() {
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
        System.out.print("Given Array In Sorted Form : ");
        System.out.println(Arrays.toString(arr));

        int minDiff = Integer.MAX_VALUE, currDiff = 0;
        for (int i = 0; i <= (arr.length - students); i++) {
            System.out.print(" " + (i + 1) + " :  [ ");
            for (int j = i; j < (i + students); j++) {
                System.out.print(arr[j] + " ");
            }
            currDiff = (arr[i + students - 1] - arr[i]);
            System.out.println("] - " + currDiff);
            minDiff = Math.min(minDiff, currDiff);

        }

        System.out.println("Minimun Difference In Chocolate Distribution Is : " + minDiff);

    }

    public static void main(String[] args) {
        ChocolateDistributionProblem();
    }
}
