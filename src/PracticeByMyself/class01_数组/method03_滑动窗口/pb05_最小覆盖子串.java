package PracticeByMyself.class01_数组.method03_滑动窗口;

import java.util.HashMap;

/**
 * @author mdy
 * @date 2024-12-18 10:20
 * @description <a href="https://leetcode.cn/problems/minimum-window-substring/description/">...</a>
 * 思路1：用滑动窗口+valid位
 */
public class pb05_最小覆盖子串 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String source, String target) {

        // 思路1：利用valid变量来记录window中的字符是否满足要求

        // 用于存储当前window中存在的字符的个数
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needMap = new HashMap<>();

        for (char c : target.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }


        int left = 0, right = 0;
        int valid = 0;
        char[] sourceChars = source.toCharArray();
        while (right < source.length()) {
            char curChar = sourceChars[right];
            window.put(curChar, window.getOrDefault(curChar, 0) + 1);
            // 增大窗口
            right++;
            // 如果目前window中curChar字符的个数刚好和needMap中的一样，说明可以匹配上一位
            if (needMap.containsKey(curChar)) {
                if (window.get(curChar).equals(needMap.get(curChar))) {
                    valid++;
                }
            }

            // 如果valid匹配位的个数等于needMap中元素的个数，说明当前窗口中的元素已经满足条件
            while (left < right && valid == needMap.size()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char removeChar = sourceChars[left];
                if (needMap.containsKey(removeChar)) {
                    if (window.get(removeChar).equals(needMap.get(removeChar))) {
                        valid--;
                    }
                }
                window.put(removeChar, window.get(removeChar) - 1);
                left++;
            }
        }


        return minLen == Integer.MAX_VALUE ? "" : source.substring(start, start + minLen);
    }

}
