package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.*;

/**
 * @author Martin
 * @date 2025/1/8 12:16
 * @description <a href="https://leetcode.cn/problems/find-mode-in-binary-search-tree/description/">...</a>
 * 思路1：中序遍历BST，记录当前数的count
 */

public class pb14_BST中的众数 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("6,2,8,0,4,7,9,null,null,2,6");
        System.out.println(Arrays.toString(findMode(root))); // [2,6]
    }

    static int curNumCount, maxCount;
    static TreeNode preNode;
    static LinkedList<Integer> validNumList;
    public static int[] findMode(TreeNode root) {
        maxCount = 0;
        preNode = null;
        validNumList = new LinkedList<>();
        traverse(root);

        int[] res = new int[validNumList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = validNumList.get(i);
        }
        return res;
    }

    static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        if (preNode == null || preNode.val != root.val) {
            curNumCount = 0;
        }

        curNumCount++;
        if (curNumCount > maxCount) {
            maxCount = curNumCount;
            validNumList.clear();
            validNumList.addLast(root.val);
        } else if (curNumCount == maxCount) {
            validNumList.addLast(root.val);
        }

        preNode = root;
        traverse(root.right);
    }

}
