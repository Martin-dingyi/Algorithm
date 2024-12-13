package PracticeByMyself;

import java.util.Arrays;

/**
 * @author mdy
 * @date 2024-11-16 19:25
 * @description
 */
public class code002_RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }


    public static int removeElement(int[] nums, int val) {
        int k = nums.length;
        int ptrHead = 0;
        int ptrEnd = nums.length - 1;
        while (ptrHead <= ptrEnd) {
            if (nums[ptrHead] == val) {
                swap(nums, ptrHead, ptrEnd--);
                k--;
            } else {
                ptrHead++;
            }
        }
        return k;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
