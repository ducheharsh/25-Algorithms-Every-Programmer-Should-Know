import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Element found, return its index
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Element not found, return -1
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the sorted array: ");
        int len = sc.nextInt();

        int[] arr = new int[len];

        System.out.println("Enter the sorted elements of the array:");
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the element to search for: ");
        int target = sc.nextInt();

        // Binary search requires a sorted array, so we'll sort it first.
        Arrays.sort(arr);

        int index = binarySearch(arr, target);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found in the array.");
        }

        sc.close();
    }
}




/* This Java program, named `BinarySearch`, allows a user to perform binary search on a sorted array of integers to find a target element. Here's a detailed description of the program's functionality:

1. **Import Statements**: The program begins by importing two Java libraries: `java.util.Arrays` and `java.util.Scanner`, which are used for array manipulation and user input, respectively.

2. **Binary Search Method (`binarySearch`)**:
   - This method takes two parameters: an integer array `arr` and an integer `target`.
   - It initializes two pointers, `left` and `right`, to the start and end of the array, respectively.
   - It enters a `while` loop that continues as long as `left` is less than or equal to `right`, ensuring that the search space is not empty.
   - Inside the loop:
     - It calculates the middle index `mid` using the formula `mid = left + (right - left) / 2`. This formula ensures that `mid` is always the midpoint of the current search range.
     - It checks if the element at the middle index, `arr[mid]`, is equal to the `target`. If they are equal, it returns `mid`, indicating that the element has been found.
     - If `arr[mid]` is less than `target`, it means the `target` may be in the right half of the array, so it updates `left` to `mid + 1` to search in the right half.
     - If `arr[mid]` is greater than `target`, it means the `target` may be in the left half of the array, so it updates `right` to `mid - 1` to search in the left half.
   - If the loop exits without finding the target element, the method returns -1, indicating that the element was not found.

3. **Main Method (`main`)**:
   - The `main` method is the program's entry point.
   - It creates a `Scanner` object, `sc`, to read user input.
   - It prompts the user to enter the length of the sorted array and reads the input into the variable `len`.
   - It creates an integer array, `arr`, with a length of `len`, which will store the sorted elements of the array.
   - The program then prompts the user to enter the sorted elements of the array one by one, and it stores them in the `arr` array.
   - Next, the user is asked to enter the element they want to search for, and the input is stored in the variable `target`.
   - To ensure the array is sorted (a prerequisite for binary search), the program uses `Arrays.sort(arr)` to sort it in ascending order.
   - It calls the `binarySearch` method with the sorted array `arr` and the target `target`, and stores the result in the variable `index`.
   - Finally, it checks the value of `index` and prints whether the element was found or not, along with its index if found.

4. **Closing Scanner**: The program closes the `Scanner` object to release resources when it's done with user input.

Overall, this program provides a user-friendly way to perform binary search on a sorted array, helping users locate elements efficiently.*/
=======
/* The provided Java program is an implementation of the binary search algorithm. Binary search is used to find a specific element in a sorted array efficiently. Here's a description of the program:

Import Statements:

The program starts with importing two Java utility classes: java.util.Arrays and java.util.Scanner. These classes are used to work with arrays and read input from the user, respectively.
binarySearch Method:

This method is used to perform the binary search algorithm.
It takes two parameters: an integer array arr and an integer target that represents the element to be searched in the array.
The method initializes two pointers, left and right, to the beginning and end of the array, respectively.
It enters a while loop that continues as long as the left pointer is less than or equal to the right pointer.
Inside the loop, it calculates the middle index, mid, of the current search range.
It compares the element at the mid index with the target. If they are equal, it returns the mid as the index where the target was found.
If the element at mid is less than the target, it updates the left pointer to mid + 1 to search in the right half of the array.
If the element at mid is greater than the target, it updates the right pointer to mid - 1 to search in the left half of the array.
If the element is not found within the loop, the method returns -1 to indicate that the target is not present in the array.
main Method:

The main method is the entry point of the program.
It creates a Scanner object (sc) to read input from the user.
It prompts the user to enter the length of the sorted array and reads the input into the len variable.
It creates an integer array arr with a length of len to store the sorted elements.
It prompts the user to enter the sorted elements of the array and populates the arr array with the input values.
It prompts the user to enter the element to search for and reads it into the target variable.
Before performing the binary search, it sorts the arr array using the Arrays.sort method to ensure it is in ascending order.
It calls the binarySearch method to search for the target in the sorted array.
If the element is found (i.e., index is not -1), it prints the index where it was found.
If the element is not found, it prints a message indicating that the element was not found.
Finally, it closes the Scanner object to release system resources.
Overall, this program demonstrates the binary search algorithm by allowing the user to input a sorted array and then searching for a specified element within that array. It provides feedback on whether the element was found and at which index if it exists in the array.
*/

