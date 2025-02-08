package PracticeByMyself.class04_二叉树;

import common.entity.Node;

/**
 * @author Martin
 * @date 2025/1/4 10:06
 * @description <a href="https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/">...</a>
 */

public class pb27_N叉树的最大深度 {


    public static void main(String[] args) {

    }

    // 定义：获取所有子树的最大深度，然后返回root的最大深度
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }

        return max + 1;
    }

    // 遍历
    public int maxDepth_traverse(Node root) {
        max = 0;
        traverse(root, 1);
        return max;
    }

    static int max;
    static void traverse(Node root, int depth) {
        if (root == null) {
            return;
        }
        max = Math.max(max, depth);

        for (Node child : root.children) {
            traverse(child, depth + 1);
        }
    }
}
