package PracticeByMyself.class04_二叉树.二叉搜索树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.HashMap;

/**
 * @author Martin
 * @date 2024/12/30 11:24
 * @description <a href="https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/">...</a>
 */

public class pb09_子树最大键值和 {

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.deserializeTree("1,4,3,2,4,2,5,null,null,null,null,null,null,4,6");
        TreeNode root2 = TreeUtils.deserializeTree("4,8,null,6,1,9,null,-5,4,null,null,null,-3,null,10");
        TreeNode root3 = TreeUtils.deserializeTree("0,9,-8,6,-6,9,3,-5,1,7,1,0,null,-6,null,-4,1,null,3,2,null,null,null,null,null,null,null,null,null,null,null,4,null,10,8,null,null,null,null,1,13,-1,2,10,16,null,null,null,6,null,12,null,17");
        TreeNode root = TreeUtils.deserializeTree("4,3,null,1,2");
        System.out.println(maxSumBST(root1)); // 20
        System.out.println(maxSumBST(root2)); // 14
        System.out.println(maxSumBST(root3)); // 84
        System.out.println(maxSumBST(root)); // 2
    }

    public static int maxSumBST(TreeNode root) {
        maxSum = 0;
        getInfo(root);
        return maxSum;
    }

    // 遍历的思维解题
    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 判断左右子树是否为BST
        // 1.如果是则获取各个子树的sum，并判断root是不是BST，然后更新max的值
        // 2.如果不是，则继续遍历子树上的结点
    }

    // 依然是遍历的思维，但在后序位置利用左右子树的数据做简化
    public static int maxSum;
    // 在后序位置能拿到什么？左右子树的最大值、最小值、和、是否为BST
    // 我们定义一个长度为4的数组，1号位置表明root树是否为BST（值为1表示是BST）、2号和3号表明最小值和最大值，4号位置表明root树的和
    public static int[] getInfo(TreeNode root) {
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] leftInfo = getInfo(root.left);
        int[] rightInfo = getInfo(root.right);

        int[] rootInfo = new int[4];
        // 我们要做的仅仅是根据遍历左右子树后的值，去计算新的值
        rootInfo[1] = Math.min(Math.min(leftInfo[1], rightInfo[1]), root.val);
        rootInfo[2] = Math.max(Math.max(leftInfo[2], rightInfo[2]), root.val);
        rootInfo[3] += leftInfo[3] + rightInfo[3] + root.val;
        if (leftInfo[0] == 1 && rightInfo[0] == 1) {
            maxSum = Math.max(Math.max(leftInfo[3], rightInfo[3]), maxSum);
            if (root.val > leftInfo[2] && root.val < rightInfo[1]) {
                // root结点的值大于左子树的最大值，小于右子树的最小值，表明root是一颗BST
                rootInfo[0] = 1;
                maxSum = Math.max(maxSum, rootInfo[3]);
            }
        }

        return rootInfo;
    }

}
