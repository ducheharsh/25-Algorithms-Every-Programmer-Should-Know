import java.util.Arrays;
import java.util.Collections;

public class InbuiltRevSort {

    public static void main(String[] args) {
        // Sorting in descending order
        Integer[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(arr);

        Arrays.sort(arr, Collections.reverseOrder()); // Sort in descending order

        System.out.println("\nSorted Array (Descending Order):");
        printArray(arr);
    }

    public static void printArray(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
