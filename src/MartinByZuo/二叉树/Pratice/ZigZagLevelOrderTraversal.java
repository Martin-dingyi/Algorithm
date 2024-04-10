package MartinByZuo.二叉树.Pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagLevelOrderTraversal {
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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        l = r = 0;
        queue[r++] = root;
        boolean toggle = true;
        while (l < r) {
            int size = r - l;
            int lastR = r - 1;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (queue[l].left != null) {
                    queue[r++] = queue[l].left;
                }
                if (queue[l].right != null) {
                    queue[r++] = queue[l].right;
                }
                if (toggle) {
                    list.add(queue[l].val);
                } else {
                    list.add(queue[lastR--].val);
                }
                l++;
            }
            toggle = !toggle;
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
        System.out.println(Arrays.toString(zigzagLevelOrder(root).toArray()));
    }

}
