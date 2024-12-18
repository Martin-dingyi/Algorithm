package PracticeByMyself.class01_数组.method01_哈希表;

import java.util.*;

/**
 * @author mdy
 * @date 2024-12-07 17:11
 * @description <a href="https://leetcode.cn/problems/top-k-frequent-elements/">...</a>
 * 思路1：哈希表计数，大根堆排序
 */
public class pb05_topKFrequent {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((v1, v2) -> map.get(v2) - map.get(v1));

        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        priorityQueue.addAll(map.keySet());
        for (int i = 0; i < res.length; i++) {
            if (priorityQueue.peek() != null) {
                res[i] = priorityQueue.poll();
            }
        }

        return res;
    }
}
