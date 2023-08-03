import java.util.Arrays;

public class ContainsDuplicates {

    private static void ContainsDuplicates(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Arrays Contains Duplicates.");
                    return;
                }
            }
        }
        System.out.println("Arrays Does Not Contains Duplicates.");
    }

    public static void main(String[] args) {
        int arr[] = { 53, -41, 63, 49, 25, -6, -7 , 53 };
        System.out.println("Given Array : " + Arrays.toString(arr));
        ContainsDuplicates(arr);
    }
}
