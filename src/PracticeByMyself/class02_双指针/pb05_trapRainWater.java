package PracticeByMyself.class02_双指针;

/**
 * @author mdy
 * @date 2024-12-13 17:11
 * @description <a href="https://leetcode.cn/problems/trapping-rain-water/description/">...</a>
 */
public class pb05_trapRainWater {

    public static int trap(int[] height) {
        int waterSum = 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];

        while (left < right) {
            if (leftMax <= rightMax) {
                waterSum += Math.max(leftMax - height[left++], 0);
                leftMax = Math.max(leftMax, height[left]);
            } else {
                waterSum += Math.max(rightMax - height[right--], 0);
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return waterSum;
    }
}
