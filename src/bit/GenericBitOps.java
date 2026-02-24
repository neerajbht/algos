package bit;

public class GenericBitOps {

    public static String getEvenOrOdd(int n) {
        /*
         * find odd or even number
         * The last bit of all odd numbers is always 1, while for even numbers it’s 0.
         * So, when performing bitwise AND operation with 1, odd numbers give 1, and
         * even numbers give 0.
         * 
         */
        if ((n & 1) == 0)
            return "Even";
        return "Odd";
    }

    public void swapNumber(int a, int b) {

        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println("a =  " + a + " b = " + b);

    }

    public void arithSum(int a, int b, int n) {
        /**
         * Arithmetic Progression series is like = 2, 3, 4, 5, 6.
         * tN = a1 + (n-1) * d
         * d is = b-a
         * 
         */

    }

    static boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to square root of n
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    // Recursive function to calculate GCD using Euclidean algorithm
    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    /**
     * LCM(a,b) * GCD(a,b)= a*b
     */
    static int lcm(int a, int b) {
        return ((a * b) / gcd(a, b));
    }

    public static void main(String[] ards) {

        GenericBitOps gp = new GenericBitOps();

        gp.swapNumber(10, 20);

    }

}
