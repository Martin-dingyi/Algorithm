package PracticeByMyself.class05_图.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Martin
 * @date 2025/2/8 15:22
 * @description <a href="https://leetcode.cn/problems/minimum-height-trees/">...</a>
 * 思路1：把所有结点都当成根求一遍高度
 * 思路2：逆向的bfs。bfs是从里往外遍历，遍历所有节点一定需要的步骤数一定最少，所有只需要从外往里找根节点即可。
 */

public class pb05_好题_最小高度树 {

    public static void main(String[] args) {

    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        // 将图转成邻接表，并记录所有结点的度
        List<Integer>[] graph = new List[n];
        int[] degree = new int[n];
        buildGraph(edges, graph, degree);
        // 循环排除度为1的结点，直到剩下的结点数小于等予2
        while (n > 2) {
            // 找到度为1的点
            List<Integer> deletedNodes = new ArrayList<>();
            for (int i = 0; i < degree.length; i++) {
                if (degree[i] == 1 && graph[i] != null) {
                    deletedNodes.add(i);
                }
            }

            // 删除度为1的结点，并修改邻居的度
            for (Integer deletedNode : deletedNodes) {
                n--;
                // 减去邻居的度
                List<Integer> neighbors = graph[deletedNode];
                for (Integer neighbor : neighbors) {
                    degree[neighbor]--;
                }
                graph[deletedNode] = null;
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] != null) {
                ans.add(i);
            }
        }
        return ans;
    }

    private static void buildGraph(int[][] edges, List<Integer>[] graph, int[] degree) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
            degree[from]++;
            degree[to]++;
        }
    }
}
