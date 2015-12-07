import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.LongStream.range;


public class Problem21 {
    private static List<Long> divisors(long n) {
        return range(1, n / 2 + 1)
                .filter(i -> n % i == 0)
                .boxed()
                .collect(toList());
    }

    private static long d(long n) {
        return divisors(n).stream()
                .mapToLong(Long::valueOf)
                .sum();
    }

    public static long solve() {
        Map<Long, Long> divsSum = range(1, 10000)
                .mapToObj(i -> asList(i, d(i)))
                .collect(toMap(l -> l.get(0), l -> l.get(1)));

        return divsSum.keySet().stream()
                .mapToLong(Long::valueOf)
                .filter(i -> divsSum.containsKey(divsSum.get(i))
                        && divsSum.get(i) != i
                        && divsSum.get(divsSum.get(i)) == i)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(solve());
    }
}
