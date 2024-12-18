package PracticeByMyself.class01_数组.method03_滑动窗口;

import java.util.HashMap;

/**
 * @author mdy
 * @date 2024-12-17 11:47
 * @description
 */
public class pb02_LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        
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
