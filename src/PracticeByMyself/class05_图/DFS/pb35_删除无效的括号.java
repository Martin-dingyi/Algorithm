package PracticeByMyself.class05_图.DFS;

import java.util.*;

/**
 * @author Martin
 * @date 2025/1/30 17:03
 * @description <a href="https://leetcode.cn/problems/remove-invalid-parentheses/description/">...</a>
 * 思路1：
 */

public class pb35_删除无效的括号 {

    public static void main(String[] args) {

    }

    static Set<String> ans;
    static int minCount;
    public static List<String> removeInvalidParentheses(String s) {
        ans = new HashSet<>();
        minCount = Integer.MAX_VALUE;
        traverse(s, 0, new StringBuilder(), 0, 0);
        return new ArrayList<>(ans);
    }

    static void traverse(String s, int index, StringBuilder path, int deleteCount, int leftCount) {
        if (index == s.length()) {
            if (leftCount == 0 && deleteCount <= minCount) {
                minCount = deleteCount;
                ans.add(path.toString());
            }
            return;
        }

        if (leftCount < 0) {
            return;
        }
        // 做决策：要么删掉括号，要么保留括号
        char curChar = s.charAt(index);

        // 保留括号
        path.append(curChar);
        traverse(s, index + 1, path, deleteCount, curChar == '(' ? leftCount + 1 : curChar == ')' ? leftCount - 1 : leftCount);
        path.deleteCharAt(path.length() - 1);

        // 删掉括号
        if (curChar == ')' || curChar == '(') {
            traverse(s, index + 1, path, deleteCount + 1, leftCount);
        }
    }

    private static boolean isValid(String s) {
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                left--;
                if (left < 0) {
                    return false;
                }
            }
        }
        return left == 0;
    }

}
