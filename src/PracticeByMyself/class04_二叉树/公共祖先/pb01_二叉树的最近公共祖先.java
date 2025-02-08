package PracticeByMyself.class04_二叉树.公共祖先;

import common.entity.TreeNode;
import common.utils.TreeUtils;

/**
 * @author Martin
 * @date 2025/1/8 15:37
 * @description <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/">...</a>
 * 思路1：如果能从一个root中找到p和q，就说明它是祖先，然后再去检查它的左右子结点是否能找到；循环这个步骤就能找到最近的祖先。
 */

public class pb01_二叉树的最近公共祖先 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("3,5,1,6,2,0,8,null,null,7,4");
        TreeNode p,q;
        p = root.left;
        q = root.right;
        System.out.println(lowestCommonAncestor(root, p, q)); // 3
    }

    // 递归函数定义：寻找p或q，显然如果root只包含p或q中的一个，我们可以直接递归返回它的指针
    // 但如果同时包含两个，可能在某个结点x的后序位置发生冲突，发生冲突就返回这个结点x
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 在先序位置寻找p或q，找到就返回，找不到就继续往下遍历，直到为null。
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftIsLcaOrTargetNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightIsLcaOrTargetNode = lowestCommonAncestor(root.right, p, q);
        // 在后序位置做判断，在左右子树都找到p或q时，根据定义就返回这个结点
        if (leftIsLcaOrTargetNode != null && rightIsLcaOrTargetNode != null) {
            return root;
        }

        // 如果只有一个子树找到p或q，没有冲突，直接返回不为空的那个
        return leftIsLcaOrTargetNode != null ? leftIsLcaOrTargetNode : rightIsLcaOrTargetNode;
    }

}
