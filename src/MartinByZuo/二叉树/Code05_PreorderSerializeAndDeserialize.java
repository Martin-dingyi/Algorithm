package MartinByZuo.二叉树;

// 题目：利用先序遍历序列化和反序列化二叉树
// 提醒一点，中序遍历无法序列化
public class Code05_PreorderSerializeAndDeserialize {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }

    // 先序遍历二叉树，将结点的值保存在StringBuilder中，用逗号分隔
    // 如果遇到空结点，用#表示。
    public static int index = 1;
    public static String serialize(TreeNode root) {
        index = 1;
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    public static void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(node.val).append(",");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    public static TreeNode deserialize(String data) {
        String[] tree = data.split(",");
        if (tree[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        link(root, tree);
        return root;
    }


    // 作用：将一个父结点的左右子树都连上
    public static void link(TreeNode root, String[] tree) {
        if (tree[index].equals("#")) {
            root.left = null;
            index++;
        } else {
            root.left = new TreeNode(Integer.parseInt(tree[index++]));
            link(root.left, tree);
        }
        if (tree[index].equals("#")) {
            root.right = null;
            index++;
        } else {
            root.right = new TreeNode(Integer.parseInt(tree[index++]));
            link(root.right, tree);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(serialize(root));
        preOrderPrint(root);
        System.out.println();
        root = deserialize(serialize(root));
        preOrderPrint(root);
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
