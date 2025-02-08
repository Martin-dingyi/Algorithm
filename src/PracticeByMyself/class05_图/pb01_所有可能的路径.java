package PracticeByMyself.class05_图;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/12 10:58
 * @description <a href="https://leetcode.cn/problems/all-paths-from-source-to-target/">...</a>
 * 注意：传入的graph含义是结点所连接的其他结点的下标。
 * 思路1：
 */

public class pb01_所有可能的路径 {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2}, // 第一行
                {3},    // 第二行
                {3},    // 第三行
                {}      // 第四行
        };
        System.out.println(allPathsSourceTarget(graph)); // [[0,1,3],[0,2,3]]
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(graph, 0, new LinkedList<>(), res);
        return res;
    }

    static void dfs(int[][] graph, int nodeNum, List<Integer> path, List<List<Integer>> res) {
        path.add(nodeNum);
        if (nodeNum == graph.length - 1) {
            res.add(new LinkedList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        // 先序位置
        for (int i = 0; i < graph[nodeNum].length; i++) {
            dfs(graph, graph[nodeNum][i], path, res);
        }
        // 后序位置
        path.remove(path.size() - 1);
    }

}
