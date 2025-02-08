package PracticeByMyself.class05_图.BFS;

import common.entity.TreeNode;
import common.utils.TreeUtils;

import java.util.*;

/**
 * @author Martin
 * @date 2025/2/8 14:56
 * @description <a href="https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/">...</a>
 * 思路1：将树转成图，然后使用bfs
 */

public class pb04_二叉树中所有距离为K的结点 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.deserializeTree("3,5,1,6,2,0,8,null,null,7,4");
        System.out.println(distanceK(root, root.left, 2));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = treeToGraph(root, visited);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target.val);
        visited.put(target.val, Boolean.TRUE);
        int distance = 0;
        while (!queue.isEmpty()) {
            if (distance == k) {
                while (!queue.isEmpty()) {
                    ans.add(queue.poll());
                }
            }
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                Integer curNode = queue.poll();
                List<Integer> neighbors = graph.get(curNode);
                for (Integer neighbor : neighbors) {
                    if (visited.get(neighbor)) continue;
                    visited.put(neighbor, Boolean.TRUE);
                    queue.offer(neighbor);
                }
            }
        }
        return ans;
    }

    private static HashMap<Integer, List<Integer>> treeToGraph(TreeNode root, HashMap<Integer, Boolean> visited) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (!graph.containsKey(curNode.val)) {
                    graph.put(curNode.val, new ArrayList<>());
                    visited.put(curNode.val, Boolean.FALSE);
                }

                if (curNode.left != null) {
                    graph.get(curNode.val).add(curNode.left.val);
                    if (!graph.containsKey(curNode.left.val)) {
                        graph.put(curNode.left.val, new ArrayList<>());
                        visited.put(curNode.left.val, Boolean.FALSE);
                    }
                    graph.get(curNode.left.val).add(curNode.val);
                    queue.offer(curNode.left);
                }

                if (curNode.right != null) {
                    graph.get(curNode.val).add(curNode.right.val);
                    if (!graph.containsKey(curNode.right.val)) {
                        graph.put(curNode.right.val, new ArrayList<>());
                        visited.put(curNode.right.val, Boolean.FALSE);
                    }
                    graph.get(curNode.right.val).add(curNode.val);
                    queue.offer(curNode.right);
                }
            }
        }

        return graph;
    }

}
