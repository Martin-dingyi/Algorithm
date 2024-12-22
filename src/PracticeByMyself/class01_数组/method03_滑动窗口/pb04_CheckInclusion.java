package PracticeByMyself.class01_数组.method03_滑动窗口;

/**
 * @author mdy
 * @date 2024-12-17 17:50
 * @description <a href="https://leetcode.cn/problems/permutation-in-string/">...</a>
 * 思路1：利用哈希表记录s1各个字符出现的次数，在记录s2滑动窗口中各个字符出现的次数
 * 如果对得上，就表示存在。
 * 思路2：思路2换数组实现
 */
public class pb04_CheckInclusion {

    public static void main(String[] args) {
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        System.out.println(checkInclusion(s1, s2));
        System.out.println(checkInclusion2(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int[] needMap = new int[26];
        int[] window = new int[26];

        int needValidCnt = 0;
        for (char c : chars1) {
            needMap[c - 'a']++;
            if (needMap[c - 'a'] == 1) {
                needValidCnt++;
            }
        }

        int left = 0, right = 0;
        while (right < chars2.length) {
            char curChar = chars2[right++];
            window[curChar - 'a']++;

            if (needMap[curChar - 'a'] != 0
                    && needMap[curChar - 'a'] == window[curChar - 'a']) {
                needValidCnt--;
            }

            // 如果当前字符不被s1包含，left++
            // 或者当前字符包含，但数量太多，也需要left++
            while (left < right && (needMap[curChar - 'a'] == 0
                    || window[curChar - 'a'] > needMap[curChar - 'a'])
                    ) {
                char removeChar = chars2[left++];
                if (needMap[removeChar - 'a'] == window[removeChar - 'a']) {
                    needValidCnt++;
                }
                window[removeChar - 'a']--;
            }

            if (needValidCnt == 0) {
                return true;
            }

        }

        return false;
    }


    // 这种方法简单而且更快，但不通用，如果不是字符不仅限有字符就不好用了。
    public static boolean checkInclusion2(String s1, String s2) {

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
