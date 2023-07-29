import java.util.Scanner;

class B_BinarySearch {

    public static int BinarySearch(int[] arr, int n) { // O(Log(N))

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of an array : ");
        int len = sc.nextInt();

        int arr[] = new int[len];
        System.out.println("Enter the elements in array : ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Arrays is : ");
        System.out.print("{ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("}");

        System.out.println("Enter the element to find : ");
        int ele = sc.nextInt();

        System.out.println("Element found at : " + BinarySearch(arr, ele));

    }
}