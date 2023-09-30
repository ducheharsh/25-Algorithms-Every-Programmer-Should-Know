public class EuclideanAlgorithm {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a = 48, b = 18;
        int gcdResult = gcd(a, b);
        System.out.println("GCD of " + a + " and " + b + " is " + gcdResult);
    }
}

/*
The provided Java program demonstrates the use of the Euclidean Algorithm to calculate the greatest common divisor (GCD) of two integers. Here's a description of the program:

EuclideanAlgorithm Class:

This is the main class that contains the gcd method for calculating the GCD and the main method for testing the GCD calculation.
gcd Method:

The gcd method is a recursive function that calculates the GCD of two integers, a and b, using the Euclidean Algorithm.
It takes two integer parameters, a and b, representing the numbers for which the GCD is to be calculated.
The base case of the recursion is when b equals 0. In this case, it returns a because the GCD of any number and 0 is the number itself.
If b is not zero, it recursively calls the gcd method with b as the new value of a and a % b as the new value of b. This step continues until b becomes 0, at which point the GCD is found and returned.
main Method:

The main method is the entry point of the program.
It initializes two integers, a and b, with the values 48 and 18, respectively, for which the GCD is to be calculated.
It calls the gcd method with these values and stores the result in the gcdResult variable.
It then prints the result by displaying a message that includes the values of a and b, along with the calculated GCD.
Overall, this program provides a straightforward demonstration of how to calculate the GCD of two integers using the Euclidean Algorithm. In this specific example, it calculates and prints the GCD of 48 and 18, but you can easily modify the values of a and b to calculate the GCD of other pairs of integers.
*/
