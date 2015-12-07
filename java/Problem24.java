import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;

public class Problem24 {
    public static List<Integer> solve() {
        return permutations(asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)).get(999999);
    }

    public static List<Integer> solve1() {
        return permutations1(asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)).get(999999);
    }

    public static List<List<Integer>> permutations(List<Integer> input) {
        if (input.size() < 2)
            return singletonList(input);
        else {
            List<List<Integer>> permutations = new ArrayList<>();

            for (int i = 0; i < input.size(); i++) {
                List<Integer> src = new ArrayList<>(input);
                int first = src.remove(i);

                List<List<Integer>> subPs = permutations(src);
                for (List<Integer> lst : subPs)
                    lst.add(0, first);

                permutations.addAll(subPs);
            }
            return permutations;
        }
    }

    public static List<List<Integer>> permutations1(List<Integer> input) {
        return input.size() < 2
                ? singletonList(input)
                : input.parallelStream()
                .flatMap(
                        i -> {
                            List<Integer> src = new ArrayList<>(input);
                            src.remove(i);
                            return permutations(src).parallelStream()
                                    .map(l -> {
                                        l.add(0, i);
                                        return l;
                                    });
                        }).collect(toList());
    }

    public static void measure(Runnable r) {
        long t1, t2, dt;
        t1 = System.nanoTime();

        r.run();

        t2 = System.nanoTime();
        dt = (t2 - t1) / 1000000;
        System.out.println("time: " + dt);
    }

    public static void main(String[] args) {
        measure(() -> System.out.println(solve1()));

        System.out.println("[2, 7, 8, 3, 9, 1, 5, 4, 6, 0]");
    }
}
