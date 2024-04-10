package ByMartinPratice.二叉树.Pratice;

import java.util.Arrays;
import java.util.HashMap;

public class WidthOfBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode[] queue = new TreeNode[3001];
    public static int l = 0;
    public static int r = 0;

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        HashMap<TreeNode, Integer> map = new HashMap<>();
        l = r = 0;
        queue[r++] = root;
        map.put(queue[l], 1);
        while (l < r) {
            int size = r - l;
            ans = Math.max(ans, (map.get(queue[r - 1]) - map.get(queue[l])) + 1);
            for (int i = 0; i < size; i++) {
                if (queue[l].left != null) {
                    queue[r] = queue[l].left;
                    map.put(queue[r++], map.get(queue[l]) * 2);
                }
                if (queue[l].right != null) {
                    queue[r] = queue[l].right;
                    map.put(queue[r++], map.get(queue[l]) * 2 + 1);
                }
                l++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(100);  // correct
        root.left.left = new TreeNode(4);
        root.left.right = null;
        root.right.left = null;
        root.left.left.left = new TreeNode(1);
        root.right.right.right = new TreeNode(2);
        System.out.println(widthOfBinaryTree(root));
    }
}
