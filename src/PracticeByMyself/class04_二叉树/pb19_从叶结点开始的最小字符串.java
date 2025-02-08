package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author Martin
 * @date 2025/1/1 11:37
 * @description <a href="https://leetcode.cn/problems/smallest-string-starting-from-leaf/">...</a>
 * 思路1：a的ASCII码是97，所以映射关系为num+97=字符
 */

public class pb19_从叶结点开始的最小字符串 {

    public static void main(String[] args) {
        TreeNode root1 = TreeUtils.deserializeTree("0,1,2,3,4,3,4");
        TreeNode root2 = TreeUtils.deserializeTree("3,9,20,null,null,15,7");
//        System.out.println(smallestFromLeaf(root1)); // dba 310
        System.out.println(smallestFromLeaf(root2)); // hud
    }

    static String minStr;
    public static String smallestFromLeaf(TreeNode root) {
        minStr = null;
        traverse(root, new StringBuilder());
        return minStr;
    }
    static void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            String curStr = sb.reverse().toString();
            if (minStr == null || minStr.compareTo(curStr) > 0) {
                minStr = curStr;
            }
            sb.reverse();
        } else {
            traverse(root.left, sb);
            traverse(root.right, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    private static LinkedList<Integer> getMinStr(LinkedList<Integer> maxList, LinkedList<Integer> list) {
        if (maxList.isEmpty()) {
            return list;
        }
        if (maxList.size() <= list.size()) {
            // 如果list更长
            for (int i = 0; i < list.size(); i++) {
                if (i == maxList.size()) {
                    break;
                }
                if (list.get(i) < maxList.get(i)) {
                    return new LinkedList<>(list);
                }
            }
            return new LinkedList<>(maxList);
        } else {
            // 如果maxList更长
            // max:abcc  list:abc
            for (int i = 0; i < maxList.size(); i++) {
                if (i == list.size()) {
                    break;
                }
                if (maxList.get(i) < list.get(i)) {
                    return new LinkedList<>(maxList);
                }
            }
            return new LinkedList<>(list);
        }
    }

    private static String numMapToChar( LinkedList<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : list) {
            sb.append((char) ('a' + num));
        }

        return sb.toString();
    }
}
