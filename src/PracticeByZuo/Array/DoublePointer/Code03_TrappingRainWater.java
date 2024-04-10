package PracticeByZuo.Array.DoublePointer;



// 接雨水
// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
// 测试链接 : https://leetcode.cn/problems/trapping-rain-water/

// 技巧：相向双指针，数学证明（比较好想）
// 定理1：当前柱子的左右两边只要存在比自己高的柱子，则当前柱子一定能接到水，水量为两边最高峰较低的那个的高度 - 该柱子高度
// 定理2：
public class Code03_TrappingRainWater {
    public static int trap(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int n = height.length;
        int rainSum = 0;
        // 两边高，中间低呈V字型的区域才能接水.
        // V型有两种，一种是左低右高；还有一种是左高右低。
        // 用两个指针指向两端，中间所有山峰都小于等于两边的山峰
        int left = 0, right = 1;
        while (left < n - 1 && right < n - 1) {
            int innerVol = 0;
            int leftPeak;
            // 1.先找到开始递减的山峰，用left标记左山峰
            while (left < n - 1 && right < n - 1 && height[right] >= height[left]) {
                right++;
                left++;
            }
            leftPeak = left;
            // 下降
            while (left < n - 1 && right < n - 1 && height[right] < height[leftPeak]) {
                innerVol += height[right];
                left++;
                right++;
            }
            if (right != n - 1 || height[right] >= height[leftPeak]) {
                rainSum += Math.min(height[leftPeak], height[right]) * (right - leftPeak - 1) - innerVol;
            }
        }
        left = 0;
        right = 1;
        if (!reverse(height)) {
            while (left < n - 1 && right < n - 1) {
                int innerVol = 0;
                int leftPeak;
                // 1.先找到开始递减的山峰，用left标记左山峰
                while (left < n - 1 && right < n - 1 && height[right] >= height[left]) {
                    right++;
                    left++;
                }
                leftPeak = left;
                // 下降
                while (left < n - 1 && right < n - 1 && height[right] <= height[leftPeak]) {
                    innerVol += height[right];
                    left++;
                    right++;
                }
                if (right != n - 1 || height[right] > height[leftPeak]) {
                    rainSum += Math.min(height[leftPeak], height[right]) * (right - leftPeak - 1) - innerVol;
                }
            }
        }
        return rainSum;
    }

    // 翻转数组
    public static boolean reverse(int[] nums) {
        boolean isPail = true;
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
            if (nums[i] != nums[nums.length - i - 1]) {
                isPail = false;
            }
        }
        return isPail;
    }


    // 练习别人的解法
    public static int practice(int[] height) {
        int waterSum = 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        // left和right最后共同指向的一定是最高峰，所以最后一个柱子能借到的雨水肯定是0，不需要验证。
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



    // 别人的解法，发现的规律比我的第一个解法要更简洁。
    // 只要一个柱子的左右各有比它高的柱子，它就会提供一些雨水。
    // 并且在左（右）山峰确定的情况下，如果左（右）山峰低于右（左）指针指向的山峰，那么当前柱子一定能提供雨水。
    public int trap_others(int[] height) {
        int L = 1, R = height.length - 2, ans = 0;
        int Lmax = height[0], Rmax = height[height.length - 1];
        while (L <= R) {
            if (Lmax < Rmax) {
                ans += Math.max(0, Lmax - height[L]);
                Lmax = Math.max(Lmax, height[L++]);
            } else {
                ans += Math.max(0, Rmax - height[R]);
                Rmax = Math.max(Rmax, height[R--]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; // 6
        int[] height2 = {4, 2, 0, 3, 2, 5}; // 9
        int[] height3 = {2, 0, 2}; // 2
        int[] height4 = {5, 5, 1, 7, 1, 1, 5, 2, 7, 6}; // 23
        int[] height5 = {3, 9, 2, 2, 8, 8, 7, 3}; // 12
        int[] height6 = {2, 1, 0, 2}; // 3
        int[] height7 = {6, 0, 0, 5, 7};
//        System.out.println(practice(height1));
//        System.out.println(practice(height2));
//        System.out.println(trap(height3));
//        System.out.println(trap(height4));
        System.out.println(practice(height5));
        System.out.println(trap(height6));
    }
}
