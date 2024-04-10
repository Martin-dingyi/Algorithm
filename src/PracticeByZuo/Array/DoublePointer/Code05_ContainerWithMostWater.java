package PracticeByZuo.Array.DoublePointer;


// 盛最多水的容器
// 测试链接 : https://leetcode.cn/problems/container-with-most-water/

// 用到的技巧：同向双指针猜出的数学定理。
public class Code05_ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int waterSumMax = 0, left = 0, right = height.length - 1;

        // 两端点形成的容器的接水量 = Math.min(height[left], height[right]) * (right - left)
        while (left < right) {
            waterSumMax = Math.max(waterSumMax, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return waterSumMax;
    }


    public static void main(String[] args) {
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height2 = {1, 2, 4, 3};
        int[] height3 = {1, 0, 0, 0, 0, 0, 0, 2, 2};
        int[] height4 = {2, 3, 10, 5, 7, 8, 9};
        int[] height5 = {1, 3, 2, 5, 25, 24, 5};
        System.out.println(maxArea(height1)); // 49
        System.out.println(maxArea(height2)); // 4
        System.out.println(maxArea(height3)); // 8
        System.out.println(maxArea(height4)); // 36
        System.out.println(maxArea(height5)); // 24
    }

}
