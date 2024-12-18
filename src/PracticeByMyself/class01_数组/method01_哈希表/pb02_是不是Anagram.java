package PracticeByMyself.class01_数组.method01_哈希表;

/**
 * @author mdy
 * @date 2024-12-07 15:43
 * @description <a href="https://leetcode.cn/problems/valid-anagram/">...</a>
 * 思路1：哈希表计数（可改用数组映射来计数，效率更高）
 */
public class pb02_是不是Anagram {

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
