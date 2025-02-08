package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin
 * @date 2024/12/28 12:59
 * @description <a href="https://leetcode.cn/problems/find-duplicate-subtrees/">...</a>
 * 思路1：递归函数定义：获取左右子树的遍历序列，添加到map中。
 */

public class pb14_寻找重复的子树 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinaryTreeByLevelOrder(List.of(1, 2, 2));
        System.out.println(findDuplicateSubtrees(root)); // 2
    }

    public static HashMap<String, Integer> subTreeCount;
    static List<TreeNode> ans;
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subTreeCount = new HashMap<>();
        ans = new LinkedList<>();
        getSubTreeString(root);
        return ans;
    }

    // 递归函数定义：获取左右子树的遍历序列，添加到map中。
    public static String getSubTreeString(TreeNode root) {
        if (root == null) {
            return " ";
        }

        String leftSubStr = getSubTreeString(root.left);
        String rightSubStr = getSubTreeString(root.right);
        subTreeCount.put(leftSubStr, subTreeCount.getOrDefault(leftSubStr, 0) + 1);
        if (!leftSubStr.equals(" ") && subTreeCount.get(leftSubStr) == 2) {
            ans.add(root.left);
        }
        subTreeCount.put(rightSubStr, subTreeCount.getOrDefault(rightSubStr, 0) + 1);
        if (!rightSubStr.equals(" ") && subTreeCount.get(rightSubStr) == 2) {
            ans.add(root.right);
        }

        StringBuilder sb= new StringBuilder();
        sb.append(root.val).append("_").append(leftSubStr).append(rightSubStr);

        return sb.toString();
    }

}
