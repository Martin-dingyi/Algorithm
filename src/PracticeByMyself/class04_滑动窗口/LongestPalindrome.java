package PracticeByMyself.class04_滑动窗口;

/**
 * @author mdy
 * @date 2024-12-16 21:02
 * @description
 */
public class LongestPalindrome {



    public static void main(String[] args) {
        String source = "babad";
        System.out.println(longestPalindrome(source));
    }

    private static String[][] cache;

    public static String longestPalindrome(String s) {
        if (s.length() < 2 || isPalindrome(s, 0, s.length() - 1)) {
            return s;
        }

        cache = new String[s.length()][s.length()];

        int left = 0;
        int right = s.length() - 1;

        String res1 = findLongest(s, left, right - 1);
        String res2 = findLongest(s, left + 1, right);
        return res1.length() > res2.length() ? res1 : res2;
    }

    private static String findLongest(String s, int left, int right) {
        if (left == right) {
            return s.substring(left, left + 1);
        }

        if (cache[left][right] != null) {
            return cache[left][right];
        }

        if (isPalindrome(s, left, right)) {
            return s.substring(left, right + 1);
        } else {
            cache[left][right - 1] = findLongest(s, left, right - 1);
            cache[left + 1][right] = findLongest(s, left + 1, right);
            return cache[left][right - 1].length() > cache[left + 1][right].length() ?
                    cache[left][right - 1] : cache[left + 1][right];
        }

    }


    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
