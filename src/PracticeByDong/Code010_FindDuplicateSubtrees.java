package PracticeByDong;

import java.util.*;

// 寻找重复的子树
// https://leetcode.cn/problems/find-duplicate-subtrees/description/
public class Code010_FindDuplicateSubtrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // map中键放入根节点的值，字符串数组放所有该值对应的左右子树
        // 字符串数组的形式：左子树先序遍历结果+#+右子树先序遍历结果
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        getStruct(root, map, ans);
        return ans;
    }

    public static String getStruct(TreeNode root, HashMap<String, Integer> map, List<TreeNode> ans) {
        if (root == null) {
            return "";
        }
        String serialize = root.val + "#" + getStruct(root.left, map, ans) + "#" + getStruct(root.right, map, ans);
        map.put(serialize, map.getOrDefault(serialize, 0) + 1);
        if (map.get(serialize) == 2) {
            ans.add(root);
        }
        return serialize;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));
        root.left.left = new TreeNode(4);
        List<TreeNode> ans = findDuplicateSubtrees(root);
        for (TreeNode n : ans) {
            System.out.println(n.val);
        }
    }
}
