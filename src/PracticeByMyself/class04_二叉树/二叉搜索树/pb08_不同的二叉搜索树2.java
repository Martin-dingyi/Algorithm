package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin
 * @date 2024/12/30 11:03
 * @description <a href="https://leetcode.cn/problems/unique-binary-search-trees-ii/description/">...</a>
 */

public class pb08_不同的二叉搜索树2 {

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }

    public static List<TreeNode> generateTrees(int n) {
        return getBSTList(1, n);
    }

    // 递归函数定义：后序。根据范围构建所有可能的BST，返回所有根节点
    public static List<TreeNode> getBSTList(int leftBound, int rightBound) {
        List<TreeNode> rootList = new LinkedList<>();

        if (leftBound > rightBound) {
            rootList.add(null);
            return rootList;
        }

        int curNum = leftBound;
        // 所有可用的num都当一回根节点
        while (curNum <= rightBound) {
            List<TreeNode> leftRootList = getBSTList(leftBound, curNum - 1);
            List<TreeNode> rightRootList = getBSTList(curNum + 1, rightBound);

            for (TreeNode leftRoot : leftRootList) {
                for (TreeNode rightRoot : rightRootList) {
                    TreeNode root = new TreeNode(curNum);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    rootList.add(root);
                }
            }
            curNum++;
        }

        return rootList;
    }

}
