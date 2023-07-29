import java.util.Scanner;

class A_LinearSearch {

    public static void LinearSearch(int[] arr, int ele) { // O(N)

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                System.out.println("Element Found At Position [ " + i + " ] in given array.");
                return;
            }
        }
        System.out.println("Element not found.");
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

        LinearSearch(arr, ele);

    }
}