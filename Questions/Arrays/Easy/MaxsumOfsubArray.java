
import java.util.Arrays;

public class MaxsumOfsubArray {
    private static int MaximumSubArray(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int arr[] = { 53, -41, 63, 49, 25, -6, -7 };
        System.out.println("Given Array : " + Arrays.toString(arr));
        int maxSum = MaximumSubArray(arr);
        System.out.println("Maximum subarray sum: " + maxSum);
    }

    private static void MaximumSubArrayWithKadane(int[] arr) {
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
}
