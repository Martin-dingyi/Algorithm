package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/27 14:46
 * @description <a href="https://leetcode.cn/problems/palindrome-partitioning/description/">...</a>
 * 这题是个集合划分类题目
 */

public class pb18_分割回文串 {

    public static void main(String[] args) {

    }

    static List<List<String>> ans;
    public static List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        traverse(s, 0, new ArrayList<>());
        return ans;
    }

    // validSubStr会记录所有满足条件的子串
    static void traverse(String s, int begin, List<String> validSubStr) {
        if (begin >= s.length()) {
            ans.add(new ArrayList<>(validSubStr));
            return;
        }

        for (int i = begin; i < s.length(); i++) {
            if (isPalindrome(s, begin, i)) {
                validSubStr.add(s.substring(begin, i + 1));
                traverse(s, i + 1, validSubStr);
                validSubStr.remove(validSubStr.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s, int begin, int end) {
        while (begin <= end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
