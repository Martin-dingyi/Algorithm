package PracticeByMyself.class01_数组.method03_滑动窗口;

/**
 * @author mdy
 * @date 2024-12-20 15:44
 * @description <a href="https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/description/">...</a>
 * 思路1：map保存不合法的字符，如果包含不合法字符，left直接跳。
 * 字符串s中如果不包含非法字符，那它就是那个满足条件的子串。
 * 找什么时候left++，废弃方案：1.至少有一个字符个数达到k；2.遇到非法字符
 * 思路2：利用非法字符把字符串分割，用分治法求解
 */
public class pb12_至少有k个重复字符的最长子串 {

    public static void main(String[] args) {
        String s1 = "aaabb";
        String s2 = "bbaaacbd";
        String s3 = "baaabcb";
        System.out.println(longestSubstring(s1, 3)); // 3
        System.out.println(longestSubstring(s2, 3)); // 3
        System.out.println(longestSubstring(s3, 3)); // 3
    }

    public static int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int[] charCount = new int[26];

        for (char c : chars) {
            charCount[c - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            int count = charCount[chars[i] - 'a'];
            if (count < k && count > 0) {
                // 小优化，防止重非法字符连续排列
                int subStrIndex = i + 1;
                while (subStrIndex < chars.length && charCount[chars[subStrIndex] - 'a'] < k) {
                    subStrIndex++;
                }
                return Math.max(longestSubstring(s.substring(0, i), k),
                        longestSubstring(s.substring(subStrIndex, chars.length), k));
            }
        }

        return s.length();
    }


    public static int longestSubstring2(String s, int k) {
        int maxLen = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();

        for (int i = 1; i <= 26; i++) {
            maxLen = Math.max(maxLen, longestSubByCategory(chars, k, i));
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }

    static int longestSubByCategory(char[] chars, int k, int category) {

        int maxLen = Integer.MIN_VALUE;
        char[] charCount = new char[26];
        int categoryCount = 0;
        int left = 0, right = 0;
        while (right < chars.length) {
            int curCharIndex = chars[right++] - 'a';
            if (charCount[curCharIndex]++ == 0) {
                categoryCount++;
            }

            while (left < right && categoryCount > category) {
                if (--charCount[chars[left++] - 'a'] == 0) {
                    categoryCount--;
                }
            }
            if (isValid(chars, left, right, k)) {
                maxLen = Math.max(maxLen, right - left);
            }
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }

    public static boolean isValid(char[] chars, int begin, int end, int k) {
        int[] charCount = new int[26];
        while (begin < end) {
            charCount[chars[begin++] - 'a']++;
        }

        for (int count : charCount) {
            if (count > 0 && count < k) {
                return false;
            }
        }
        return true;
    }


}
