package PracticeByMyself.class04_滑动窗口;

import java.util.HashSet;

/**
 * @author mdy
 * @date 2024-12-18 11:17
 * @description
 */
public class pb07_无重复最长子串 {

    public static void main(String[] args) {
        String s = "au";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int maxLen = 1;

        HashSet<Character> window = new HashSet<>();

        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        while (right < chars.length) {
            char curChar = chars[right];
            boolean addSuccess = window.add(curChar);
            right++;

            if (addSuccess) {
                maxLen = Math.max(maxLen, right - left);
            } else {
                while (!window.add(curChar) && left < right) {
                    char removeChar = chars[left++];
                    window.remove(removeChar);
                }
            }

        }

        return maxLen;
    }
}
