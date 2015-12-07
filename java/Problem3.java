
public class Problem3 {
    public static void main(String[] args) {
        long n = 600851475143L;
        long factor = factor(n);
        System.out.println(factor);
    }

    public static long factor(long n) {
        for (long i = 2; i < n / 2; i++) {
            if (n % i == 0 && isPrime(i)) {
                return factor(n / i);
            }
        }
        return n;
    }

    public static boolean isPrime(long n) {
        long half = n/2;
        for (long i = 2; i <= half; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
