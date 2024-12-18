package PracticeByMyself.class01_数组.method05_前缀和;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-12-09 13:04
 * @description <a href="https://leetcode.cn/problems/product-of-array-except-self/description/">...</a>
 *  思路1：使用前缀积
 */
public class pb06_ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefixProduct = new int[n];
        int[] subfixProduct = new int[n];
        int[] res = new int[n];

        // 计算并保存前缀积和后缀积
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prefixProduct[i] = 1;
                subfixProduct[n - i - 1] = 1;
            } else {
                prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
                subfixProduct[n - i - 1] = subfixProduct[n - i] * nums[n - i];
            }
        }

        for (int i = 0; i < n; i++) {
            res[i] = prefixProduct[i] * subfixProduct[i];
        }

        return res;
    }
}
