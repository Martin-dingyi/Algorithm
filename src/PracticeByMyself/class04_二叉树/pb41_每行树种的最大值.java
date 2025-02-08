package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/1/6 10:36
 * @description <a href="https://leetcode.cn/problems/find-largest-value-in-each-tree-row/">...</a>
 */

public class pb41_每行树种的最大值 {

    public static void main(String[] args) {

    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> maxList = new LinkedList<>();
        traverse(root, 0, maxList);
        return maxList;
    }

    static void traverse(TreeNode root, int depth, List<Integer> maxList) {
        if (root == null) {
            return;
        }
        if (maxList.size() <= depth) {
            maxList.add(root.val);
        } else {
            maxList.set(depth, Math.max(maxList.get(depth), root.val));
        }

        traverse(root.left, depth + 1, maxList);
        traverse(root.right, depth + 1, maxList);
    }

}
