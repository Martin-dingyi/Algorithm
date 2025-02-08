package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/30 20:47
 * @description <a href="https://leetcode.cn/problems/generate-parentheses/">...</a>
 */

public class pb36_括号生成 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    static List<String> ans;
    public static List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        traverse(n, 0, 0, new StringBuilder());
        return ans;
    }

    static void traverse(int n, int leftCount, int rightCount, StringBuilder path) {
        if (leftCount == n && leftCount == rightCount) {
            ans.add(path.toString());
            return;
        }

        if (leftCount > n || rightCount > n || rightCount > leftCount) {
            return;
        }

        path.append("(");
        traverse(n, leftCount + 1, rightCount, path);
        path.deleteCharAt(path.length() - 1);

        path.append(")");
        traverse(n, leftCount, rightCount + 1, path);
        path.deleteCharAt(path.length() - 1);
    }
}
