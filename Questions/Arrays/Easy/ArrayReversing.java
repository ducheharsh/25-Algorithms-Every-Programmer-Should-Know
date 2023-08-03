
import java.util.Arrays;

public class ArrayReversing {

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

    public static void main(String[] args) {
        int arr[] = { 53, -41, 63, 49, 25, -6, -7 };
        System.out.println("Given Array : " + Arrays.toString(arr));
        ReverseArray(arr);
    }
}
