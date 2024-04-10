package MartinByZuo.二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 题目：二叉树的层序遍历
public class Code03_LevelOrderTraversal {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode[] queue = new TreeNode[2001];
    public static int l = 0;
    public static int r = 0;

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        l = r = 0;
        queue[r++] = root;
        while (l < r) {
            List<Integer> list = new ArrayList<>();
            int size = r - l;
            for (int i = 0; i < size; i++) {
                if (queue[l].left != null) {
                    queue[r++] = queue[l].left;
                }
                if (queue[l].right != null) {
                    queue[r++] = queue[l].right;
                }
                list.add(queue[l++].val);
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(Arrays.toString(levelOrder(root).toArray()));
    }
}
