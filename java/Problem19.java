import java.util.List;

import static java.util.Arrays.asList;

public class Problem19 {
    private static List<Integer> monthsRegular = asList(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    private static List<Integer> monthsLeap = asList(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

    private static boolean isLeap(int year) {
        return year % 400 == 0
                || (year % 100 != 0 && year % 4 == 0);
    }

    public static void main(String[] args) {
        int pos = 1 + monthsRegular.stream().reduce((a,b) -> a + b).get(); //pos for jan 1, 1901
        int sundays = 0;

        for (int y = 1901; y < 2001; y++) {
            List<Integer> months = isLeap(y) ? monthsLeap : monthsRegular;
            for (int days : months) {
                if (pos % 7 == 0) {
                    sundays++;
                }
                pos += days;
            }
        }
        System.out.println(sundays);
    }
}
