import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static void main(String[] args) {
        List<Long> factors = new ArrayList<>();
        for (long i = 1; i <= 20; i++) {
            if (Problem3.isPrime(i)) {
                factors.add(i);
            } else {
                factors = union(factors, factors(i));
            }
        }

        factors.stream()
                .reduce((a, b) -> a * b)
                .ifPresent(System.out::println);
    }

    public static List<Long> factors(long n) {
        for (long i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                long factor = n / i;
                if (Problem3.isPrime(factor)) {
                    List<Long> factors = new ArrayList<>();
                    factors.add(i);
                    factors.add(factor);
                    return factors;
                } else {
                    List<Long> factors = factors(n / i);
                    factors.add(i);
                    return factors;
                }
            }
        }
        return new ArrayList<>();
    }

    public static List<Long> union(List<Long> ls1, List<Long> ls2) {
        List<Long> ls = new ArrayList<>();
        ls.addAll(ls1);
        for (Long l : ls2) {
            int i = ls.indexOf(l);
            if (i != -1) {
                ls.remove(i);
            }
        }
        ls.addAll(ls2);
        return ls;
    }
}
