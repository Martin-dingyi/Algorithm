package PracticeByMyself.class01_数组.method03_滑动窗口;

/**
 * @author mdy
 * @date 2024-12-17 17:50
 * @description <a href="https://leetcode.cn/problems/permutation-in-string/">...</a>
 */
public class pb04_CheckInclusion {

    public static void main(String[] args) {
        String s1 = "r";
        String s2 = "pilmtnzraxj";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {

        // 1.简单思路，列出s1所有排列组合，再从s2找是否存在子串
        // 2.思路2：利用哈希表记录s1各个字符出现的次数，在记录s2滑动窗口中各个字符出现的次数
        // 如果对得上，就表示存在。
        // 3.思路3：给s1排序，再给s2的滑动窗口中的字符串排序，比较是否相同即可
        // 4.思路4：思路2换数组实现
        int length1 = s1.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int[] charCount1 = new int[26];
        int[] charCount2 = new int[26];

        for (char c : chars1) {
            charCount1[c - 'a']++;
        }

        for (int left = 0, right = 0; right < chars2.length; right++) {

            charCount2[chars2[right] - 'a']++;

            if (right - left + 1 != length1) {
                continue;
            }

            if (isCharCountEqual(charCount1, charCount2)) {
                return true;
            }

            charCount2[chars2[left++] - 'a']--;
        }

        return false;
    }

    private static boolean isCharCountEqual(int[] charCount1, int[] charCount2) {
        for (int i = 0; i < charCount1.length; i++) {
            if (charCount1[i] != charCount2[i]) {
                return false;
            }
        }

        return true;
    }

}
