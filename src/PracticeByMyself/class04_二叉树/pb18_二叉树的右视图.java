package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/1 11:19
 * @description <a href="https://leetcode.cn/problems/binary-tree-right-side-view/">...</a>
 * 思路1：使用层次遍历，打印每次queue中最右边的元素
 * 思路2：
 */

public class pb18_二叉树的右视图 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("1,2,3,null,5,null,4");
        System.out.println(rightSideView(root)); //1,3,4
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traverse(root, 0, list);
        return list;
    }

    // DFS解法
    static void traverse(TreeNode root, int depth, List<Integer> list) {
        if (root == null) {
            return;
        }

        depth++;
        // 第一次进入这一层，添加进map，否则不添加
        if (list.size() < depth) {
            list.add(root.val);
        }
        traverse(root.right, depth, list);
        traverse(root.left, depth, list);
    }
}
