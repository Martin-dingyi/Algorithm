package common;

import java.util.Arrays;

/**
 * @author Martin
 * @date 2024/12/23 20:45
 * @description
 */

public class ArrayUtils {

    // 可能产生长度为0的数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1))
                    - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    /**
     * 产生元素个数不为0，且值全是正数的数组
     * @param maxSize 最大尺寸
     * @param maxValue 最大值
     * @return 数组
     */
    public static int[] generateRandomNoMinusArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue + 1);
        }
        return arr;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public boolean isEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        System.arraycopy(arr, 0, res, 0, arr.length);
        return res;
    }

    public static void print(int [] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void check(boolean success) {
        System.out.println(success ? "成功" : "失败");
    }
}
