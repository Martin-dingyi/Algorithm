package PracticeByMyself.class02_双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mdy
 * @date 2024-12-12 9:47
 * @description <a href="https://leetcode.cn/problems/3sum/">...</a>
 */
public class pb03_threeSum {

    public static void main(String[] args) {
        int[] nums1 = {0, 0, 0, 0};
        int[] nums2 = {-1,0,1,2,-1,-4};
        int[] nums3 = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println(threeSum(nums1));
        System.out.println(threeSum(nums2));
        System.out.println(threeSum(nums3));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left;
        int right;

        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = nums.length - 1;
            if (nums[i] > 0) {
                break;
            }

           if (i > 0 && i < right && nums[i] == nums[i - 1]) {
                continue;
           }

            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
//                    List<Integer> list = new ArrayList<>(List.of(nums[i], nums[left], nums[right]));
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while(left < right && nums[left] == nums[++left]);
                    while(left < right && nums[right] == nums[--right]);
                }
            }
        }

        return res;
    }
}
