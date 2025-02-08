package PracticeByMyself.class04_二叉树.二叉搜索树;

/**
 * @author Martin
 * @date 2024/12/30 10:25
 * @description <a href="https://leetcode.cn/problems/unique-binary-search-trees/">...</a>
 * 思路1：这题已经涉及到动态规划，暂时不要深究
 */

public class pb07_不同的二叉搜索树 {

    public static void main(String[] args) {
        System.out.println(numTrees(3)); // 5
        System.out.println(numTrees(18)); // 477638700
    }

    public static int[][] cached;
    public static int numTrees(int n) {
        cached = new int[n + 1][n + 1];
        return getBSTCount(1, n);
    }

    // 递归函数定义：后序。根据可取值的范围构建BST，返回可以构建多少个
    public static int getBSTCount(int leftBound, int rightBound) {
        if (leftBound > rightBound) {
            return 1;
        }

        if (cached[leftBound][rightBound] != 0) {
            return cached[leftBound][rightBound];
        }

        int curNum = leftBound;
        int count = 0;
        // 所有可用的num都当一回根节点
        while (curNum <= rightBound) {
            count += getBSTCount(leftBound, curNum - 1) * getBSTCount(curNum + 1, rightBound);
            curNum++;
        }

        cached[leftBound][rightBound] = count;
        return count;
    }
}
