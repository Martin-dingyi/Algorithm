package PracticeByMyself.class01_数组;

import java.util.HashMap;

/**
 * @author mdy
 * @date 2024-12-07 15:43
 * @description <a href="https://leetcode.cn/problems/valid-anagram/">...</a>
 */
public class pb02_isAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        int[] charCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int count = --charCounts[t.charAt(i) - 'a'];
            if (count < 0) {
                return false;
            }
        }

        for (int charCount : charCounts) {
            if (charCount != 0) {
                return false;
            }
        }

        return true;
    }

}
