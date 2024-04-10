package PracticeByZuo;

import java.util.Arrays;

public class Comparator {
    public Comparator() {
    }
    public int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1))
                    - (int) (Math.random() * maxValue);
        }
        return arr;
    }

    public int[] generateRandomNoMinusArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue + 1);
        }
        return arr;
    }

    public void comparator(int[] arr) {
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

    public int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void print(int [] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public void check(boolean success) {
        System.out.println(success ? "成功" : "失败");
    }

}
