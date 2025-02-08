package PracticeByMyself.class05_图;

/**
 * @author Martin
 * @date 2025/1/18 13:57
 * @description <a href="https://leetcode.cn/problems/validate-binary-tree-nodes/">...</a>
 * 思路1：找到规律，有效二叉树根节点入度必须是0，其他所有结点的入度必须为1，且整个图的连通分量必须为1
 */

public class pb09_验证二叉树 {

    public static void main(String[] args) {
        int[] leftChild = {1,-1,3,-1};
        int[] rightChild = {2,3,-1,-1};
    }

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];

        // 初始化入度数组，顺便检查二叉树合法性
        for (int i = 0; i < n; i++) {
            int leftChildNum = leftChild[i], rightChildNum = rightChild[i];

            if ((leftChildNum != -1 && ++inDegree[leftChildNum] > 1) ||
                    (rightChildNum != -1 && ++inDegree[rightChildNum] > 1)) {
                return false;
            }
        }

        // 找根节点
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (root != -1) return false;
                root = i;
            }
        }

        // 检测连通分量是否为1
        boolean[] visited = new boolean[n];
        dfs(leftChild, rightChild, root, visited);
        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int[] leftChild, int[] rightChild, int s, boolean[] visited) {
        if (s == -1 || visited[s]) {
            return;
        }
        visited[s] = true;
        dfs(leftChild, rightChild, leftChild[s], visited);
        dfs(leftChild, rightChild, rightChild[s], visited);
    }
}
