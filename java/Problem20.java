import java.math.BigInteger;
import java.util.stream.Stream;

import static java.util.stream.LongStream.range;

public class Problem20 {
    private static BigInteger fact(long n) {
        return range(1, n+1)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger::multiply)
                .get();
    }

    private static int sumDigits(BigInteger bi) {
        return Stream.of(bi.toString().split(""))
                .mapToInt(Integer::valueOf)
                .sum();
    }

    public static int solve() {
        return sumDigits(fact(100));
    }

    public static void main(String[] args) {
        System.out.println(solve());
    }
}
