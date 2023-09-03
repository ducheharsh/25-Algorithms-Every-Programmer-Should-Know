import java.util.Arrays;

public class InbuiltSort {

    public static void main(String[] args) {
        // Sorting in ascending order
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(arr);

        Arrays.sort(arr); // Sort in ascending order

        System.out.println("\nSorted Array (Ascending Order):");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
