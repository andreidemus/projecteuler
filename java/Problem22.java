import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Problem22 {
    private static long weight(String s) {
        long weight = 0;
        for (char c : s.toCharArray()) {
            weight += ((int) c - 64);
        }
        return weight;
    }

    private static String trimQuotes(String s) {
        return s.substring(1, s.length() - 1);
    }

    private static Stream<String> readNames() throws IOException {
        String[] names = Files.lines(Paths.get("resources", "p022_names.txt"))
                .findFirst().get()
                .split(",");
        return Stream.of(names);
    }

    public static long solve() throws IOException {
        long sum = 0;

        List<String> names = readNames()
                .map(Problem22::trimQuotes)
                .sorted()
                .collect(toList());

        for (int i = 0; i < names.size(); i++) {
            sum += (weight(names.get(i)) * (i + 1));
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solve());
    }
}
