package PracticeByMyself.class01_数组.method02_双指针;

/**
 * @author mdy
 * @date 2024-12-12 9:15
 * @description
 */
public class pb01_isPalindrome {

    public static void main(String[] args) {
        String source = "0P";
        System.out.println(isPalindrome(source));
    }

    public static boolean isPalindrome(String s) {
        s = transferStr(s);
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }

    private static String transferStr(String s) {
        s = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if ((curChar >= 'a' && curChar <= 'z') || (curChar >= '0' && curChar <= '9')) {
                stringBuilder.append(curChar);
            }
        }

        return stringBuilder.toString();
    }
}
