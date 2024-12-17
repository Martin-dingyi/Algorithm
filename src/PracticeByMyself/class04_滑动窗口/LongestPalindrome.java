package PracticeByMyself.class04_滑动窗口;

/**
 * @author mdy
 * @date 2024-12-16 21:02
 * @description <a href="https://leetcode.cn/problems/longest-palindromic-substring/submissions/587495714/">...</a>
 */
public class LongestPalindrome {



    public static void main(String[] args) {
        String source = "ac";
        System.out.println(longestPalindrome(source));
//        System.out.println(findLongestPalindromeByMid(source, 2, 2));
    }


    public static String longestPalindrome(String s) {

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String res1 = findLongestPalindromeByMid(s, i, i);
            String res2 = findLongestPalindromeByMid(s, i, i + 1);

            res1 = res1.length() > res2.length() ? res1 :res2;
            res = res1.length() > res.length() ? res1 : res;
        }
        return res;
    }

    private static String findLongestPalindromeByMid(String s, int mid1, int mid2) {

        while(mid1 >= 0 && mid2 < s.length()) {
            if (s.charAt(mid1) != s.charAt(mid2)) {
                return s.substring(mid1 + 1, mid2);
            }
            mid1--;
            mid2++;
        }

        return s.substring(mid1 + 1, mid2);
    }


}
