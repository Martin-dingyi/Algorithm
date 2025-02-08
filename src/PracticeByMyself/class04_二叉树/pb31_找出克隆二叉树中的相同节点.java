package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

/**
 * @author Martin
 * @date 2025/1/4 11:31
 * @description <a href="https://leetcode.cn/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/submissions/591017071/">...</a>
 */

public class pb31_找出克隆二叉树中的相同节点 {

    public static void main(String[] args) {

    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return null;
        }
        if (cloned.val == target.val) {
            return cloned;
        } else {
            TreeNode leftTarget = getTargetCopy(original, cloned.left, target);
            if (leftTarget != null) {
                return leftTarget;
            }
            return getTargetCopy(original, cloned.right, target);
        }
    }
}
