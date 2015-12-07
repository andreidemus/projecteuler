import java.util.Iterator;

public class Problem2 {
    static class FibIterator implements Iterator<Long> {
        long a = 0;
        long b = 1;

        @Override
        public boolean hasNext() {
            return Long.MAX_VALUE - b >= a;
        }

        @Override
        public Long next() {
            long next = a + b;
            a = b;
            b = next;
            return next;
        }
    }

    public static void main(String[] args) {
        FibIterator fibIterator = new FibIterator();
        long sum = 0;
        long f;
        while (fibIterator.hasNext() && (f = fibIterator.next()) <= 4000000) {
            if (f % 2 == 0)
                sum += f;
        }

        System.out.println(sum);
    }
}
