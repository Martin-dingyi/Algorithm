package PracticeByMyself.class04_二叉树;

import com.sun.source.tree.Tree;
import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/2 11:22
 * @description <a href="https://leetcode.cn/problems/delete-nodes-and-return-forest/">...</a>
 */

public class pb26_好题_删点成林 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("1,2,3,4,5,6,7");
        System.out.println(delNodes(root, new int[]{3,5}));

//        List<TreeNode> list = new LinkedList<>();
//        list.add(null);
//        list.remove(0);
//        List<TreeNode> list2 = new LinkedList<>();
//        list2.add(new TreeNode(0));
//        list2.addAll(list);
//        System.out.println(list2);
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> toDeleteSet = new HashSet<>();
        for (int num : to_delete) {
            toDeleteSet.add(num);
        }
        List<TreeNode> list = new LinkedList<>();
        if (delNodes(root, list, toDeleteSet) != null) list.add(root);
        return list;
    }

    // 递归函数定义：修剪root树，将被剪下的树林添加进list，并返回修剪后的头结点，如果头结点被减掉就返回null
    public static TreeNode delNodes(TreeNode root, List<TreeNode> list, HashSet<Integer> toDeleteSet) {
        if (root == null) {
            return null;
        }

        root.left = delNodes(root.left, list, toDeleteSet);
        root.right = delNodes(root.right, list, toDeleteSet);

        if (toDeleteSet.contains(root.val)) {
            if (root.left != null) list.add(root.left);
            if (root.right != null) list.add(root.right);
            return null;
        } else {
            return root;
        }
    }

}
