package PracticeByMyself.class05_图;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/16 15:56
 * @description <a href="https://leetcode.cn/problems/possible-bipartition/">...</a>
 */

public class pb05_可能的二分法 {

    public static void main(String[] args) {

    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = buildGraph(n, dislikes);
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) {
                continue;
            }
            if (!isBipartite_dfs(graph, i, 2, visited)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBipartite_dfs(List<Integer>[] graph, int s, int preColor, int[] visited) {
        int curColor = preColor == 1 ? 2 : 1;

        visited[s] = curColor;
        for (int toNode : graph[s]) {
            if (visited[toNode] == 0) {
                if (!isBipartite_dfs(graph, toNode, curColor, visited)) {
                    return false;
                }
            } else if (visited[toNode] == curColor) {
                return false;
            }
        }

        return true;
    }

    private static List<Integer>[] buildGraph(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] dislike : dislikes) {
            int from = dislike[0] - 1, to = dislike[1] - 1;
            graph[from].add(to);
            graph[to].add(from);
        }

        return graph;
    }
}
