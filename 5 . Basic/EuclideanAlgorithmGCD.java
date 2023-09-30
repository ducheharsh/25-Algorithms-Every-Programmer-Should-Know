/*
The Euclidean algorithm is used to find the greatest common divisor (GCD) of two integers. It's an efficient method for computing the largest number that divides both of the given integers without leaving a remainder.
Here's an example of implementing the Euclidean algorithm in Java:
*/
public class EuclideanAlgorithmGCD {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a; // GCD is found when 'b' becomes 0
        } else {
            return gcd(b, a % b); // Recursive call with 'a' as 'b' and 'b' as 'a % b'
        }
    }

    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;

        int gcdResult = gcd(num1, num2);

        System.out.println("GCD of " + num1 + " and " + num2 + " is " + gcdResult);
    }
}

/*
In this code:

The gcd method takes two integers, a and b, and returns their greatest common divisor.
It uses a recursive approach to calculate the GCD. The base case is when b becomes 0, in which case the GCD is found and returned as a.
If b is not 0, it calls the gcd method again with b as the new a and a % b as the new b. This continues until b becomes 0.
In the main method:

We specify two integers, num1 and num2.
We call the gcd method with these numbers and print the result.
When you run this code, it will compute and print the GCD of the two specified numbers, which is 6 in this case. You can replace num1 and num2 with any other integer values to find the GCD for different pairs of numbers.

*/
