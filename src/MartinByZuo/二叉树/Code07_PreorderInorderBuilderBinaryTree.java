package MartinByZuo.二叉树;

import java.util.HashMap;

public class Code07_PreorderInorderBuilderBinaryTree {
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
    static HashMap<Integer, Integer> map;
    public static int n;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        n = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int root_pre = preorder[n++];
        TreeNode root = new TreeNode(root_pre);
        int root_in = map.get(root_pre);
        link(preorder, inorder, root, 0, root_in - 1, root_in + 1, preorder.length - 1);
        return root;
    }

    // 作用：将一个结点的左右子树连上
    public static void link(int[] preorder, int[] inorder, TreeNode root, int l1, int r1, int l2, int r2) {
        int root_in;
        if (l1 > r1) {
            // 如果左半部分没有结点，
            root.left = null;
        } else {
            // 如果左半部分有结点，那么先序序列的下一个结点必然是该root的左结点
            root.left = new TreeNode(preorder[n]);
            root_in = map.get(preorder[n++]);
            link(preorder, inorder, root.left, l1, root_in - 1, root_in + 1, r1);
        }
        if (l2 > r2) {
            root.right = null;
        } else {
            root.right = new TreeNode(preorder[n]);
            root_in = map.get(preorder[n++]);
            link(preorder, inorder, root.right, l2, root_in - 1, root_in + 1, r2);
        }
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20 ,15, 7};
        int[] inorder = new int[]{9,3 ,15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        preOrderPrint(root);
        System.out.println();
    }

   public static void preOrderPrint(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.print(tree.val + ",");
        preOrderPrint(tree.left);
        preOrderPrint(tree.right);
    }
}
