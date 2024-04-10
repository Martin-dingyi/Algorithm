package PracticeByZuo.Array.DoublePointer;

import java.util.Arrays;

// 按奇偶排序数组II
// 给定一个非负整数数组 nums。nums 中一半整数是奇数 ，一半整数是偶数
// 对数组进行排序，以便当 nums[i] 为奇数时，i也是奇数
// 当 nums[i] 为偶数时， i 也是 偶数
// 你可以返回 任何满足上述条件的数组作为答案
// 测试链接 : https://leetcode.cn/problems/sort-array-by-parity-ii/

// 这题用到的数组技巧：同向双指针、数据交换、数组下标
public class Code01_SortArrayByParityII {
    //
    public static int[] sortArrayByParityII(int[] nums) {
        // ptrToEven指向下标为偶数的位置，ptrToOdd指向下标为奇数的位置
        int ptrToEven = 0, ptrToOdd = 1;
        while ((ptrToEven < nums.length && ptrToOdd < nums.length)) {
            // 两个指针从左往右，找自己管的不合法的数。
            while (ptrToEven < nums.length && nums[ptrToEven] % 2 == 0) {
                ptrToEven += 2;
            }
            while (ptrToOdd < nums.length && nums[ptrToOdd] % 2 != 0) {
                ptrToOdd += 2;
            }
            if (ptrToEven < nums.length && ptrToOdd < nums.length) {
                swap(nums, ptrToEven, ptrToOdd);
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4, 0, 0, 4, 3, 3};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
    }
}
