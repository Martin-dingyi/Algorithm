package MartinByZuo.二分答案法;

// 分割数组的最大值(画匠问题)
// 给定一个非负整数数组 nums 和一个整数 m
// 你需要将这个数组分成 m 个非空的连续子数组。
// 设计一个算法使得这 m 个子数组各自和的最大值最小。
// 测试链接 : https://leetcode.cn/problems/split-array-largest-sum/
public class Code02_SplitArrayLargestSum {

    // 先将数组一分为二，答案有可能在右边，也有可能在左边，假设此时sum右更大
    // 那么子数组最大值肯定在sum右。将隔板往右移一位，如果sum右还是更大，就继续移，直到sum右不再更大为止
    // 这时为了防止，
    public static int splitArray(int[] nums, int k) {
        int ans = 0;


        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(splitArray(nums, 2));
    }
}
