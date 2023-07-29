
import java.util.Scanner; //Input
import java.util.Arrays; //InbuiltSort
import java.util.Collections; //reverseInbuiltSort

public class C_SortingTechniques {

    public static void BubbleSort(int[] ar) {
        // O(n^2)
        int swap = 0;
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = 0; j < ar.length - i - 1; j++) {
                if (ar[j] > ar[j + 1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                    swap++;
                }
                print(ar);
            }
            if (swap == 0) {
                System.out.println("\nAlready Sorted !");
                return; // O(n)
            }
        }
    }

    public static void SelectionSort(int[] ar) {
        // O(n^2)
        int swap = 0;
        for (int i = 0; i < ar.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[smallest] > ar[j]) {
                    smallest = j;
                    swap++;
                }
            }
            int temp = ar[smallest];
            ar[smallest] = ar[i];
            ar[i] = temp;
            if (swap == 0) {
                System.out.println("\nAlready Sorted !");
                return; // O(n)
            }
        }
    }

    public static void InsertionSort(int[] arr) {
        // O(n^2)
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    // O(n log n) --> very less compared to O(n^2)
    public static void InbuiltSort(int[] arr) {
        Arrays.sort(arr);
    }

    public static void InbuiltRevSort(Integer[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
    }

    public static void countingSort(int[] arr) {
        // largest element in arr array
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        // count array update
        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        // sorting in arr array
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;// i element in count = number in arr
                j++;
                count[i]--;
            }
        }

    }

    public static void print(int[] arr) {
        System.out.println("\nSorted Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void print(Integer[] arr) {
        System.out.println("\nSorted Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = { 77, 56, 88, 41, 31, 99 };
        Integer[] arri = { 77, 56, 88, 41, 31, 99 };
        System.out.println("Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        Scanner sc = new Scanner(System.in);
        int r;
        do {
            System.out.println(
                    "\nSort The Array - \n1 . Bubble Sort\n2 . Selection Sort\n3 . Insertion Sort\n4 . Inbuilt Sort\n5 . Counting Sort\n6 . Quick Sort\n7 . Merge Sort\nEnter Your Choice : ");
            int s = sc.nextInt();
            switch (s) {
                case 1:
                    BubbleSort(arr);
                    print(arr);
                    break;
                case 2:
                    SelectionSort(arr);
                    print(arr);
                    break;
                case 3:
                    InsertionSort(arr);
                    print(arr);
                    break;
                case 4:
                    InbuiltSort(arr);
                    print(arr);
                    InbuiltRevSort(arri);
                    print(arri);
                    break;
                case 5:
                    countingSort(arr);
                    print(arr);
                    break;
                case 6:
                    quickSort(arr, 0, arr.length - 1);
                    print(arr);
                    break;
                case 7:
                    mergeSort(arr, 0, arr.length - 1);
                    print(arr);
                    break;
                default:
                    System.out.println("Wrong Choice !");
            }
            System.out.println("\nDo You Want To Continue ? ");
            r = sc.nextInt();
        } while (r == 1);

        // put print(arr); in any of the sorts to know mechanism
    }

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    // Quick Sort - Theta( n log n) , O(n pow 2) when array is sorted and pivot is
    // largest or smallest element
    public static void quickSort(int[] arr, int si, int ei) {

        if (si >= ei) {
            return;
        }
        int pivot = partition(arr, si, ei);
        quickSort(arr, si, pivot - 1); // left
        quickSort(arr, pivot + 1, ei);

    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j <= ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // // while si == ei i.e si == pivot
        // i++;
        // int temp = arr[ei];
        // arr[ei] = arr[i]; //pivot = arr[i] doesn't change value , not applicable'
        // arr[i] = temp;

        return i;
    }

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    // mergeSort - O(n log n)
    public static void mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2; // (si+ei)/2
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1]; // size of temp array //auxilary array - space complexity O(n)
        int i = si;
        int j = mid + 1;
        int k = 0;

        // comparing two partitions of array
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // left partition is bigger than right one
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // right partition is bigger than left one
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }

    }

}
