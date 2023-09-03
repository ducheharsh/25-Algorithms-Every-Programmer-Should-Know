public class CountingSort {

    public static void countingSort(int[] arr) {
        int max = findMax(arr);
        int min = findMin(arr);

        int range = max - min + 1;

        // Create a count array to store the count of each element
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Count the occurrences of each element
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        // Calculate the cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy the sorted elements back to the original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Original Array:");
        printArray(arr);

        countingSort(arr);

        System.out.println("\nSorted Array:");
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
