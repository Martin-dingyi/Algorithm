package PracticeByMyself.class04_滑动窗口;

import java.util.HashMap;

/**
 * @author mdy
 * @date 2024-12-17 13:13
 * @description <a href="https://leetcode.cn/problems/longest-repeating-character-replacement/description/">...</a>
 */
public class pb03_CharacterReplacement {

    public static void main(String[] args) {
        String s1 = "ABAB";
        String s2 = "AABABBA";
        String s3 = "ABBB";
        System.out.println(characterReplacement(s1, 2)); // 4
        System.out.println(characterReplacement(s2, 1)); // 4
        System.out.println(characterReplacement(s3, 2)); // 4
    }

    public static int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] charCount = new int[26];
        int charMaxCount = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {

            char curChar = chars[right];
            charCount[curChar - 'A']++;

            // 此处为trick，你可能会担心后续的charMaxCount是不是不应该这么算
            // 因为所有比charMaxCount低的情况都不用考虑，所以即使后续真实的
            // charMaxCount不是这个数值也无所谓。
            charMaxCount = Math.max(charMaxCount, charCount[curChar - 'A']);

            // 关键：在这种情况下left移动，即滑动窗口内数量最多的那个字符的个数+k < 滑动窗口长度
            while (charMaxCount + k < right - left + 1) {
                charCount[chars[left++] - 'A']--;
            }
        }

        return Math.min(charMaxCount + k, s.length());
    }
}
