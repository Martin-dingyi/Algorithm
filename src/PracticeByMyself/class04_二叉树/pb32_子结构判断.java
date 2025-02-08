package PracticeByMyself.class04_二叉树;

import com.sun.source.tree.Tree;
import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.List;
import java.util.Set;

/**
 * @author Martin
 * @date 2025/1/4 11:37
 * @description <a href="https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/">...</a>
 * 思路1：定义：判断a的左右子树是否包含b，再判断a是否包含b。这种解法会有重复遍历的问题
 * 思路2：记录tree2的先序序列，在遍历tree1的后序位置获得子树，判断是否和tree2的先序序列相同
 */

public class pb32_子结构判断 {

    public static void main(String[] args) {
        TreeNode source = TreeUtils.deserializeTree("10,12,6,8,3,11");
        TreeNode target = TreeUtils.deserializeTree("10,12,6,8");
        System.out.println(isSubStructure(source, target)); // true
    }

    // 定义：判断a的左右子树是否包含b，再判断a是否包含b
    static boolean isSubStructure(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return false;
        }
        return isSubStructure(a.left, b) || isSubStructure(a.right, b) || isSame(a, b);
    }

    // 判断两棵树是否相同
    static boolean isSame(TreeNode source, TreeNode target) {
        if (target == null) {
            return true;
        }
        if (source == null) {
            return false;
        }
        return source.val == target.val && isSame(source.left, target.left) && isSame(source.right, target.right);
    }
}
