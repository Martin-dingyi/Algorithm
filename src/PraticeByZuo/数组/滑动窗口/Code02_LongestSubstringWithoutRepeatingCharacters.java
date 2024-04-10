package ByMartinPratice.数组.滑动窗口;


import java.util.HashMap;

// 无重复字符的最长子串
// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
// 测试链接 : https://leetcode.cn/problems/longest-substring-without-repeating-characters/
public class Code02_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charToIndex = new HashMap<>();
        int maxLen = 0;
        // 每次添加进滑动窗口一个字符，添加前判断集合中是否有重复字符
        for (int i = 0, left = 0, right = -1; i < s.length(); i++) {
            // 如果map中不存在该字符，将该字符添加进来
            // 如果map中存在该字符，left指针指向存在字符的右边一个位置
            char curChar = s.charAt(i);
            if (charToIndex.containsKey(curChar)) {
                int nextPos = charToIndex.get(curChar) + 1;
                left = Math.max(nextPos, left);
            }
            charToIndex.put(curChar, i);
            right++;
            // 每遍历一个字符，都更新子串长度
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
