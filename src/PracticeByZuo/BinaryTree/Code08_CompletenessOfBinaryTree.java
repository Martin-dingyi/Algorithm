package PracticeByZuo.BinaryTree;

// 题目：验证是否为完全二叉树
public class Code08_CompletenessOfBinaryTree {
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

    public static TreeNode[] queue = new TreeNode[101];
    public static int l, r;

    public static boolean isCompleteTree(TreeNode root) {
        l = r= 0;
        queue[r++] = root;
        boolean NoCompleteNode;
        NoCompleteNode = false;
        while (l < r) {
            int size = r - l;
            for (int i = 0; i < size; i++, l++) {
                TreeNode cur = queue[l];
                if (cur.left != null) {
                    if (NoCompleteNode) {
                        return false;
                    }
                    queue[r++] = cur.left;
                }
                if (cur.right != null) {
                    if (cur.left == null) {
                        return false;
                    }
                    queue[r++] = cur.right;
                }
                // 判断有没有不完整结点
                if (cur.left == null || cur.right == null) {
                    NoCompleteNode = true;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        System.out.println(isCompleteTree(root));
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
