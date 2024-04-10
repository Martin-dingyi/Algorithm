package ByMartinPratice.数组.双指针;


import java.util.Arrays;

// 寻找重复数
// 测试链接 : https://leetcode.cn/problems/find-the-duplicate-number/

// 这个题的技巧性非常非常强，不管是二分法还是快慢指针法，都很难想到。用快慢指针法更符合求解数组相关题目的系统
// 这题用到的技巧：从数组下标中做文章、快慢指针。

public class Code02_FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        // 以零作为起始结点，将每一个结点的值当成数组下标，该下标在数组中对应的值即为当前结点子结点的值。
        // 因为数组中必有重复数，肯定有两个不同结点指向同一个结点，即形成的链表必有环，环入口结点就是重复的数对应的结点。使用快慢指针找到环的入口。
        // slow和fast的值除了起始值是0，其余都是nums里的数值，它们指向下个位置的方法是以自己当前值为数组下标。
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static int comparator(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int next = i + 1;
            if (nums[i] == nums[next]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2};
        int[] nums2 = {3, 1, 3, 4, 2};
//        System.out.println(comparator(nums1));
        System.out.println(findDuplicate(nums1));
//        System.out.println(comparator(nums2));
        System.out.println(findDuplicate(nums2));
    }
}
