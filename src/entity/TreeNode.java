package entity;

/**
 * @author mdy
 * @date 2024-11-17 21:19
 * @description
 */


public class TreeNode {

    public int val;

    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
