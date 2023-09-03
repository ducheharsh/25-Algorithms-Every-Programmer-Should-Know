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
