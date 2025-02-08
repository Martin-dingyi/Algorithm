package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/1 10:34
 * @description <a href="https://leetcode.cn/problems/binary-tree-paths/">...</a>
 */

public class pb16_二叉树的所有路径 {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("1,2,3,null,5");
        System.out.println(binaryTreePaths(root));
    }

    public static List<String> ans;
    public static List<String> binaryTreePaths(TreeNode root) {
        ans = new LinkedList<>();
        traverse(root, new LinkedList<>());
        return ans;
    }

    static void traverse(TreeNode root, LinkedList<String> list) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
            ans.add(String.join("->", list.toArray(new String[0])));
            list.removeLast();
            return;
        }
        list.add(String.valueOf(root.val));
        traverse(root.left, list);
        traverse(root.right, list);
        list.removeLast();
    }
}
