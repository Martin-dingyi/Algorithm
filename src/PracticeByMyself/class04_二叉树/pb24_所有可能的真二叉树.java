package PracticeByMyself.class04_二叉树;

import common.entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Martin
 * @date 2025/1/2 10:48
 * @description <a href="https://leetcode.cn/problems/all-possible-full-binary-trees/">...</a>
 * 思路1：进入递归函数消耗一个点数构建结点，如果n的值为0，结束构造
 */

public class pb24_所有可能的真二叉树 {

    public static void main(String[] args) {
        System.out.println(allPossibleFBT(3));
    }

    static Map<Integer, List<TreeNode>> memo = new HashMap<>();
    public static List<TreeNode> allPossibleFBT(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        List<TreeNode> list = new LinkedList<>();
        if (n % 2 == 0) {
            return list;
        }

        for (int i = 1; i <= n - 1; i++) {
            List<TreeNode> leftRootList = allPossibleFBT(i);
            List<TreeNode> rightRootList = allPossibleFBT(n - 1 - i);
            if (!leftRootList.isEmpty() && !rightRootList.isEmpty()) {
                for (TreeNode leftRoot : leftRootList) {
                    for (TreeNode rightRoot : rightRootList) {
                        TreeNode root = new TreeNode(0);
                        root.left = leftRoot;
                        root.right = rightRoot;
                        list.add(root);
                    }
                }
            }
        }

        if (n == 1) {
            list.add(new TreeNode(0));
        }
        memo.put(n, list);
        return list;
    }
}
