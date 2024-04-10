package ByMartinPratice.二叉树;

public class Code16_HouseRobberIII {
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

    public static int rob(TreeNode root) {
        int[] ans = f(root);
        return Math.max(ans[0], ans[1]);
    }

    // 递归函数作用：获得两个值，第一个是root子树根节点被打劫时的最大值，另一个是root子树根节点不被打劫时的最大值
    // root的左右子树分别获取一次，然后根据这四个值计算root本身被打劫和不被打劫的最大值，将这个值返回。
    public static int[] f(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        // rob中第一个数表示不能访问root时，能获得的最大值；第二个数表示能访问root时，能获得的最大值
        int[] rob = new int[2];
        // 获取左右子树根节点被打劫和不被打劫时的最大值
        int[] leftRob = f(root.left);
        int[] rightRob = f(root.right);
        // 计算root自己被打劫和不被打劫时的最大值
        rob[0] = Math.max(leftRob[0], leftRob[1]) + Math.max(rightRob[0], rightRob[1]);
        rob[1] = leftRob[0] + rightRob[0] + root.val;
        return rob;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(1,
                new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(8)));
        System.out.println(rob(root));
    }
}
