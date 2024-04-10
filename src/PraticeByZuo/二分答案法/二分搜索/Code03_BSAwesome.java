package ByMartinPratice.二分答案法.二分搜索;

import java.util.Arrays;

public class Code03_BSAwesome {
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        } else if (arr[arr.length-2] > arr[arr.length-1]) {
            return arr.length-1;
        }
        int L = 1;
        int R = arr.length - 2;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return -1;
    }

    public static boolean isExist(int[] arr, int index) {
        if (arr == null || arr.length <= 1) {
            return true;
        }
        if(index == 0 && arr[index] < arr[index+1]) {
            return true;
        } else if (index == arr.length - 1 && arr[index] < arr[index-1]) {
            return true;
        }
        return arr[index - 1] > arr[index] && arr[index + 1] > arr[index];
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
//        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
//        if (arr.length == 1) {
//            arr[0]= (int) (Math.random() * (maxValue + 1))
//                    - (int) (Math.random() * maxValue);
//            return arr;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * (maxValue + 1))
//                    - (int) (Math.random() * maxValue);
//            if (i == 1) {
//                while (arr[i] == arr[0]) {
//                    arr[i] = (int) (Math.random() * (maxValue + 1))
//                            - (int) (Math.random() * maxValue);
//                }
//            } else if (i == arr.length - 1) {
//                while (arr[i] == arr[arr.length - 2]) {
//                    arr[i] = (int) (Math.random() * (maxValue + 1))
//                            - (int) (Math.random() * maxValue);
//                }
//            } else if (i != 0) {
//                while (arr[i] == arr[i - 1] || arr[i] == arr[i + 1]) {
//                    arr[i] = (int) (Math.random() * (maxValue + 1))
//                            - (int) (Math.random() * maxValue);
//                }
//            }
//        }
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        arr[0] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);  // 直接从i=1开始，避开数组只有一个数的情况
        for (int i = 1; i < arr.length; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
            } while (arr[i] == arr[i - 1]);   // 只需要和前一个数不相等即可，不用我上面那个那么麻烦
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 10;
        int maxValue = 10;
        int lessIndex;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
//            int[] arr = {7, -1, -7, 1};
            lessIndex = getLessIndex(arr);
            if(!isExist(arr, lessIndex)) {
                System.out.println(Arrays.toString(arr));
                System.out.println(lessIndex);
                success = false;
                break;
            }

        }
        System.out.println(success ? "成功" : "失败");
    }
}
