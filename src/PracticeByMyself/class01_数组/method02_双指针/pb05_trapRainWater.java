package PracticeByMyself.class01_数组.method02_双指针;

/**
 * @author mdy
 * @date 2024-12-13 17:11
 * @description <a href="https://leetcode.cn/problems/trapping-rain-water/description/">...</a>
 * 注意：这题需要很强的观察能力，已经和双指针技巧本身关系不大
 * 思路1：
 * 技巧：分析局部再分析整体，可以先看一格可以装多少雨水，和什么参数有关？
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
