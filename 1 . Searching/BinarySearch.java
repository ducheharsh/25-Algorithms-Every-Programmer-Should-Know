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
