package PracticeByMyself.class01_数组.method02_双指针;

/**
 * @author mdy
 * @date 2024-12-12 16:35
 * @description <a href="https://leetcode.cn/problems/container-with-most-water/">...</a>
 */
public class pb04_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] container = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(container));
    }

    public static int maxArea(int[] height) {
        int maxWaterVol = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // 获取当前容器可装多少水，取每次获取到的最大值
            maxWaterVol = Math.max(maxWaterVol, (right - left) * Math.min(height[right], height[left]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWaterVol;
    }


}
