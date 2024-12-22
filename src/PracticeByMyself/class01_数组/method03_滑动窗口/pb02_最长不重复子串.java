package PracticeByMyself.class01_数组.method03_滑动窗口;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author mdy
 * @date 2024-12-17 11:47
 * @description <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">...</a>
 * 思路1：使用滑动窗口，left++的时机为出现window中出现重复字符
 * 思路2：也是用滑动窗口，但不符合框架，不建议用
 */
public class pb02_最长不重复子串 {

    public static void main(String[] args) {
        String s = "aabaab!bb";
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

    public static int lengthOfLongestSubstring2(String s) {
        
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        int maxLen = 0;
        
        // 利用hashMap保存滑动窗口中的字符何其对应的下标
        for (int i = 0, left = 0, right = -1; i < s.length(); i++) {
            // 如果map中不存在该字符，将该字符添加进来
            // 如果map中存在该字符，left指针指向存在字符的右边一个位置
            char curChar = s.charAt(i);
            if (charToIndex.containsKey(curChar)) {
                int nextPos = charToIndex.get(curChar) + 1;
                // 有可能nextPos不在滑动窗口范围内，这种情况下不允许跳
                left = Math.max(nextPos, left);
            }

            charToIndex.put(curChar, i);
            right++;
            // 每遍历一个字符，都更新子串长度
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
