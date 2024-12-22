package PracticeByMyself.class99_其他;

/**
 * @author mdy
 * @date 2024-12-20 11:24
 * @description <a href="https://leetcode.cn/problems/longest-common-prefix/">...</a>
 * 思路1：随便拿出一个字符串和剩下字符串比较，就能获得公共前缀
 */
public class 最长公共前缀 {

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"a"};
        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));
    }

    public static String longestCommonPrefix(String[] strs) {

        char[] prefix = strs[0].toCharArray();
        int prefixLength = prefix.length;

        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            char[] targetChars = strs[i].toCharArray();
            int limit = Math.min(prefixLength, targetChars.length);

            while (index < limit && targetChars[index] == prefix[index]) {
                index++;
            }
            prefixLength = Math.min(prefixLength, index);
            if (prefixLength == 0) {
                break;
            }
        }

        return new String(prefix, 0, prefixLength);
    }

}
