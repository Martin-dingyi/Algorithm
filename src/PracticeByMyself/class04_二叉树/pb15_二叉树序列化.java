package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Martin
 * @date 2024/12/28 14:27
 * @description <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/description/">...</a>
 */

public class pb15_二叉树序列化 {

    public static void main(String[] args) {
        String s1 = "1,2,3,null,null,4,5";
        String s2 = "4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2";
        TreeNode root = deserialize(s1);
        String res = serialize(root);
        System.out.println(res);
        System.out.println(deserialize(res));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode == null) {
                    sb.append("null").append(",");
                } else {
                    sb.append(curNode.val).append(",");
                    if (curNode.left != null) {
                        queue.add(curNode.left);
                    } else {
                        queue.add(null);
                    }

                    if (curNode.right != null) {
                        queue.add(curNode.right);
                    } else {
                        queue.add(null);
                    }
                }
            }

        }

        // 移除多余的null
        String[] splitStr = sb.toString().split(",");
        int index = splitStr.length - 1;
        while (index >= 0) {
            if (splitStr[index].equals(" ") || splitStr[index].equals("null")) {
                index--;
            } else {
                break;
            }
        }
        sb = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            sb.append(splitStr[i]).append(",");
        }

        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.isBlank()) {
            return null;
        }

        String[] vals = data.split(",");

        String firstVal = vals[0];
        if (firstVal.equals("null")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(firstVal));
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (index >= vals.length || vals[index].equals("null")) {
                    curNode.left = null;
                } else {
                    TreeNode temp = new TreeNode(Integer.parseInt(vals[index]));
                    curNode.left = temp;
                    queue.add(temp);
                }
                index++;
                if (index >= vals.length || vals[index].equals("null")) {
                    curNode.right = null;
                } else {
                    TreeNode temp = new TreeNode(Integer.parseInt(vals[index]));
                    curNode.right = temp;
                    queue.add(temp);
                }
                index++;
            }
        }

        return root;
    }

}
