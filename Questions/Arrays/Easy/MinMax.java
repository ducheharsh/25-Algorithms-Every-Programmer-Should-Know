import java.util.Arrays;

public class MinMax {

    private static void MinMaxAlgo(int arr[]) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            } else if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("Maximum element is : " + max);
        System.out.println("Minimum element is : " + min);
    }

    public static void main(String[] args) {
        int arr[] = { 53, -41, 63, 49, 25, -6, -7, 53 };
        System.out.println("Given Array : " + Arrays.toString(arr));
        MinMaxAlgo(arr);
    }
}
