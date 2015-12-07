public class Problem4 {
    public static void main(String[] args) {
        System.out.println(getPalindromic());
    }

    public static long getPalindromic() {
        for (long i = 999 * 999; i >= 100 * 100; i--) {
            if (isPalindromic(i)) {
                for (long j = 999; j >= 100; j--) {
                    if (i % j == 0) {
                        if (i / j < 1000) {
                            return i;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isPalindromic(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
