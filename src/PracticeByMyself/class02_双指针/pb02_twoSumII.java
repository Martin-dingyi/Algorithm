package PracticeByMyself.class02_双指针;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-12-12 9:29
 * @description <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/">...</a>
 */
public class pb02_twoSumII {

    public static void main(String[] args) {
        int[] source = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(source, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return null;
    }
}
