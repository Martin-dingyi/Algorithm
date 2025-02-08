package PracticeByMyself.class05_图;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Martin
 * @date 2025/1/19 17:12
 * @description <a href="https://leetcode.cn/problems/network-delay-time/">...</a>
 */

public class pb12_网络延迟时间 {

    public static void main(String[] args) {

    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] distTo = new int[n + 1];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[0] = -1;
        Queue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distFromStart));
        pq.offer(new State(k, 0));
        distTo[k] = 0;

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.node;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curNodeID]) {
                // 已经有一条更短的路径到达 curNode 节点了
                continue;
            }
            // 将 curNode 的相邻节点装入队列
            for (int i = 0; i < times.length; i++) {
                if (times[i][0] == curNodeID) {
                    int nextNodeID = times[i][1];
                    int distToNextNode = distTo[curNodeID] + times[i][2];
                    if (distTo[nextNodeID] > distToNextNode) {
                        // 更新 dp table
                        distTo[nextNodeID] = distToNextNode;
                        // 将这个节点以及距离放入队列
                        pq.offer(new State(nextNodeID, distToNextNode));
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int dist : distTo) {
            if (dist == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(dist, max);
        }
        return max;
    }

    private static class State {
        // 当前节点 ID
        int node;
        // 从起点 s 到当前节点的权重和
        int distFromStart;

        public State(int node, int weight) {
            this.node = node;
            this.distFromStart = weight;
        }
    }
}
