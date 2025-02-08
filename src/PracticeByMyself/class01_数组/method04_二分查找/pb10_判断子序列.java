package PracticeByMyself.class01_数组.method04_二分查找;

/**
 * @author Martin
 * @date 2024/12/23
 * @description <a href="https://leetcode.cn/problems/is-subsequence/">...</a>
 * 思路：这题只是下一题的前菜，不属于二分查找类
 */

public class pb10_判断子序列 {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {

        int ptr1 = 0, ptr2 = 0;
        char[] chars1 = s.toCharArray(), chars2 = t.toCharArray();
        while (ptr1 < chars1.length && ptr2 < chars2.length) {
            if (chars1[ptr1] == chars2[ptr2]) {
                ptr1++;
            }
            ptr2++;
        }

        return ptr1 == chars1.length;
    }
}
