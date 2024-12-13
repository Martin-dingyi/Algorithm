package PracticeByMyself.class01_数组;

import java.util.HashSet;

/**
 * @author mdy
 * @date 2024-12-09 15:51
 * @description <a href="https://leetcode.cn/problems/longest-consecutive-sequence/">...</a>
 */
public class pb08_longestConsecutive {

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums2 = {0,-1};
        System.out.println(longestConsecutive(nums)); // 9
        System.out.println(longestConsecutive(nums2)); // 2
    }

    public static int longestConsecutive(int[] nums) {
        int res = 1;
        int cnt;
        // 每遍历到一个数num，循环访问HashSet看看有没有num+1，cnt也一直+1，直到没有下一个数
        // 然后把他放到set里面去
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : nums) {
            if (numSet.contains(num - 1)) {
                continue;
            }
            cnt = 1;
            int headIndex = 1;
            int backIndex = 1;
            while (numSet.contains(num + backIndex)) {
                cnt++;
                res = Math.max(res, cnt);
                numSet.remove(num + backIndex++);
            }

//            while (numSet.contains(num - headIndex)) {
//                cnt++;
//                res = Math.max(res, cnt);
//                numSet.remove(num - headIndex++);
//            }
        }

        return nums.length == 0 ? 0 : res;
    }
}
