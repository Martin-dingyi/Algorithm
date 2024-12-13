package PracticeByMyself.class01_数组;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mdy
 * @date 2024-12-07 17:11
 * @description <a href="https://leetcode.cn/problems/top-k-frequent-elements/">...</a>
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
            res[i] = priorityQueue.poll();
        }

        return res;
    }
}
