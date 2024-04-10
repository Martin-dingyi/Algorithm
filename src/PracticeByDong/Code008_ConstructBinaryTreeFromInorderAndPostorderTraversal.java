package PracticeByDong;

import java.util.HashMap;

// 根据中序和后序序列构建二叉树
// https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
public class Code008_ConstructBinaryTreeFromInorderAndPostorderTraversal {
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

    // 后序遍历反过来就是从右往左的先序遍历
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildLocTree(inorder, postorder, 0, inorder.length - 1, map);
    }

    public static int postIndex;

    // 递归函数定义：创建出根节点，并构建出它的左右子树
    public static TreeNode buildLocTree(int[] inorder, int[] postorder, int inLeft, int inRight, HashMap<Integer, Integer> map) {
        if (postIndex == postorder.length || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex--]);
        if (inLeft == inRight) {
            return root;
        }
        int index = map.get(root.val);
        root.right = buildLocTree(inorder, postorder, index + 1, inRight, map);
        root.left = buildLocTree(inorder, postorder, inLeft, index - 1, map);
        return root;
    }

    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9, 3, 15, 20, 7};
        buildTree(inorder, postorder);
    }

}
