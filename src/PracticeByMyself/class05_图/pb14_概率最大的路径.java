package PracticeByMyself.class05_图;

import java.util.*;

/**
 * @author Martin
 * @date 2025/1/23 23:05
 * @description <a href="https://leetcode.cn/problems/path-with-maximum-probability/description/">...</a>
 */

public class pb14_概率最大的路径 {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        System.out.println(maxProbability(3, edges, succProb, 0, 2));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] graph = buildGraph(n, edges, succProb);
        double[] distTo = new double[n];
        Arrays.fill(distTo, Integer.MIN_VALUE);
        distTo[start_node] = 1;
        Queue<State> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probabilityFromStart, a.probabilityFromStart));
        pq.offer(new State(start_node, 1));

        while (!pq.isEmpty()) {
            State curNode = pq.poll();
            int curNodeId = curNode.id;
            double curNodeProb = curNode.probabilityFromStart;

            if (curNodeId == end_node) {
                return curNodeProb;
            }

            if (distTo[curNodeId] > curNodeProb) {
                continue;
            }
            for (double[] doubles : graph[curNodeId]) {
                int nextNodeId = (int) doubles[0];
                double edgeWeight = doubles[1];
                double nextWeight = curNodeProb * edgeWeight;
                if (nextWeight > distTo[nextNodeId]) {
                    distTo[nextNodeId] = nextWeight;
                    pq.offer(new State(nextNodeId, nextWeight));
                }
            }
        }

        return 0;
    }

    private static List<double[]>[] buildGraph(int n, int[][] edges, double[] succProb) {
        List<double[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int NodeA = edges[i][0], NodeB = edges[i][1];
            graph[NodeA].add(new double[]{NodeB, succProb[i]});
            graph[NodeB].add(new double[]{NodeA, succProb[i]});
        }
        return graph;
    }

    private static class State {
        // 当前节点 ID
        int id;
        // 从起点 s 到当前节点的权重和
        double probabilityFromStart;

        public State(int id, double weight) {
            this.id = id;
            this.probabilityFromStart = weight;
        }
    }

}
