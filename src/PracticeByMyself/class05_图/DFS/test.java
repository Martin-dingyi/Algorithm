package PracticeByMyself.class05_图.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Martin
 * @date 2025/1/30 23:06
 * @description
 */

public class test {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(getSubSets(nums, 2));
    }

    static List<List<Integer>> ans;
    static List<Integer>[] bucket;
    static List<List<Integer>> getSubSets(int[] nums, int k) {
        ans = new ArrayList<>();
//        bucket = new List[k];
//        for (int i = 0; i < k; i++) {
//            bucket[i] = new ArrayList<>();
//        }
//        dfs(nums, 0);
        bucketList = new ArrayList<>();
        dfs_2(nums, 0);
        return ans;
    }

    // 球选桶的思路
    static void dfs(int[] nums, int index) {
        if (index == nums.length) {
            for (List<Integer> list : bucket) {
                ans.add(new ArrayList<>(list));
            }
            List<Integer> split = new ArrayList<>();
            split.add(Integer.MAX_VALUE);
            ans.add(split);
            return;
        }

        for (List<Integer> list : bucket) {
            list.add(nums[index]);
            dfs(nums, index + 1);
            list.remove(list.size() - 1);
        }
    }

    // 桶选球的思路
    static List<Integer> bucketList;
    static void dfs_2(int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(bucketList));
        }

        for (int i = index; i < nums.length; i++) {
            for (int j = index; j <= i; j++) {
                bucketList.add(nums[j]);
            }
            bucketList.add(Integer.MAX_VALUE);
            dfs_2(nums, i + 1);
            bucketList.remove(bucketList.size() - 1);
            for (int j = index; j <= i; j++) {
                bucketList.remove(bucketList.size() - 1);
            }
        }
    }
}
