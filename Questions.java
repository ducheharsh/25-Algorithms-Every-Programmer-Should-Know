import java.util.Arrays;

import javax.xml.transform.Source;

class Questions {
    public static void main(String[] args) {
        // Arrays
        // int arr[] = { 53, -41, 63, 49, 25, -6, -7, 53 };
        // System.out.println("Given Array : " + Arrays.toString(arr));
        // MinMaxAlgo(arr);
        // ReverseArray(arr);
        // MaximumSubArray(arr);
        // ContainsDuplicate(arr);
        // ChocolateDistributionProblem();
        SearchSortedNRotatedArray();
    }

    private static void SearchSortedNRotatedArray() {

        int arr[] = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int key = 0;

        int s = 0, e = arr.length - 1, mid = s + (e - s) / 2;
        while (arr[mid] < arr[mid + 1]) {
            mid = mid - 1;
        }

        if (key == arr[mid]) {
            System.out.println("Key Found at " + mid);
        } else if (key > arr[mid]) {
            System.out.println("Key Not Found.");
        } else {
            int ans1 = BinarySearch(arr, key, s, mid - 1);
            if (ans1 != -1) {
                System.out.println("Key Found at " + ans1);
                return;
            }
            int ans2 = BinarySearch(arr, key, mid + 1, e);
            if (ans2 != -1) {
                System.out.println("Key Found at " + ans2);
                return;
            }

            System.out.println("Key  Not Found.");

        }

    }

    public static int BinarySearch(int[] arr, int n, int s, int e) { // O(Log(N))

        int start = s;
        int end = e;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (n == arr[mid]) {
                return mid;
            } else if (n < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

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

    private static void ContainsDuplicate(int[] arr) {
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

    private static void MaximumSubArray(int[] arr) {
        // kadane's algorithm
        int n = arr.length;
        int maxsum = Integer.MIN_VALUE;
        int currsum = 0;

        for (int i = 0; i < n; i++) {
            currsum += arr[i];
            if (currsum < 0) {
                currsum = 0;
            }
            maxsum = Math.max(maxsum, currsum);
        }

        System.out.println("Maximum Sum Of the subarray is : " + maxsum);

    }

    private static void ReverseArray(int arr[]) {
        int first = 0, last = arr.length - 1;
        while (first < last) {
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            first++;
            last--;
        }
        System.out.println("Reversed Array Is  : " + Arrays.toString(arr));
    }

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
}