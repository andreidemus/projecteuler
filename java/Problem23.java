import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.LongStream.range;

public class Problem23 {
    private static long threshold = 28123;
    private static List<Long> abundants;

    private static List<Long> divisors(long n) {
        return range(1, n / 2 + 1)
                .parallel()
                .filter(i -> n % i == 0)
                .boxed()
                .collect(toList());
    }

    private static boolean isAbundant(long n) {
        return divisors(n).stream().mapToLong(Long::valueOf).sum() > n;
    }

    private static boolean isOfAbundants(long n) {
        for (long i : abundants()) {
            if (abundants().contains(n - i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNotOfAbundants(long n) {
        return !isOfAbundants(n);
    }

    private static List<Long> abundants() {
        if (abundants == null) {
            abundants = range(1, threshold)
                    .parallel()
                    .filter(Problem23::isAbundant)
                    .boxed()
                    .collect(toList());
        }
        return abundants;
    }

    public static long solve() {
        return range(1, threshold + 1)
                .parallel()
                .filter(Problem23::isNotOfAbundants)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(solve());
    }
}
