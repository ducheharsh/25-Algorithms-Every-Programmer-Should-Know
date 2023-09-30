public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no two elements were swapped in the inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array:");
        printArray(arr);

        bubbleSort(arr);

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


/* Here's an explanation of the key parts of the program:

bubbleSort method:

The bubbleSort method takes an integer array arr as its input and sorts it in-place using the Bubble Sort algorithm.
It starts by initializing a variable n with the length of the input array arr.
It also initializes a boolean variable swapped to keep track of whether any swaps were made in the current pass through the array.
Outer Loop:

The outer loop iterates from i = 0 to i < n - 1. This loop represents the number of passes through the array.
Inner Loop:

The inner loop, nested within the outer loop, iterates from j = 0 to j < n - i - 1. It compares adjacent elements of the array and swaps them if they are in the wrong order (i.e., if arr[j] > arr[j + 1]).
If a swap is made during this inner loop, the swapped variable is set to true.
Check for Early Termination:

After each pass through the array, the program checks the swapped variable. If no swaps were made in the inner loop (i.e., swapped is still false), it means the array is already sorted, and the outer loop can be terminated early using the break statement.
main method:

In the main method, an example integer array arr is created with unsorted values.
The original array is printed using the printArray method.
The bubbleSort method is called to sort the array.
Finally, the sorted array is printed again using the printArray method to show the result.
printArray method:

The printArray method takes an integer array arr as input and prints its elements on a single line, separated by spaces.
When you run the program, it will output the original array, perform the Bubble Sort algorithm on it, and then display the sorted array as the final result. */
