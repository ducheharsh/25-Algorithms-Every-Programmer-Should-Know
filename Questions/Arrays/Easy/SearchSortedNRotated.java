public class SearchSortedNRotated {
    private static int SearchSortedNRotatedArray() {

        int nums[] = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int target = 0;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) { // Left half is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // Right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1; // Target not found

    }

    public static void main(String[] args) {
        System.out.println("Key Found at " + SearchSortedNRotatedArray());
    }
}
