package PracticeByZuo.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 题目：用层序遍历序列化和反序列化二叉树
public class Code06_LevelOrderSerializeAndDeserialize {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }

    public static TreeNode[] queue = new TreeNode[10001];
    public static int l = 0;
    public static int r = 0;

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        levelOrderForSerialize(root, sb);
        return sb.toString();
    }

    public static void levelOrderForSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        l = r = 0;
        queue[r++] = root;
        while (l < r) {
            int size = r - l;
            for (int i = 0; i < size; i++) {
                if (queue[l] == null) {
                    sb.append("#").append(",");
                    l++;
                    break;
                } else {
                    sb.append(queue[l].val).append(",");
                }
                if (queue[l].left != null) {
                    queue[r++] = queue[l].left;
                } else {
                    queue[r++] = null;
                }
                if (queue[l].right != null) {
                    queue[r++] = queue[l].right;
                } else {
                    queue[r++] = null;
                }
                l++;
            }
        }
    }

    public static TreeNode deserialize(String data) {
        l = r = 0;
        String[] tree = data.split(",");
        TreeNode root;
        if (tree[0].equals("#")) {
            return null;
        } else {
            root = new TreeNode(Integer.parseInt(tree[0]));
        }
        queue[r++] = root;
        int index = 1;
        while (l < r) {
            int size = r - l;
            for (int i = 0; i < size; i++) {
                if (tree[index].equals("#")) {
                    queue[l].left = null;
                } else {
                    queue[l].left = new TreeNode(Integer.parseInt(tree[index]));
                    queue[r++] = queue[l].left;
                }
                index++;
                if (tree[index].equals("#")) {
                    queue[l].right = null;
                } else {
                    queue[l].right = new TreeNode(Integer.parseInt(tree[index]));
                    queue[r++] = queue[l].right;
                }
                index++;
                l++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(Arrays.toString(levelOrder(root).toArray()));
        root = deserialize(serialize(root));
        System.out.println(Arrays.toString(levelOrder(root).toArray()));
    }

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
}
