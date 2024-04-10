package PracticeByZuo.BitOperation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 第一题：一个数组中出现奇数次的数只有一个，其他所有数都出现偶数次，求这个奇数
// 第二题：一个数组中出现奇数次的数有两个，其他所有数都出现偶数次，求这两个奇数
// 第二题思路：利用两奇数的不同点将数组一分为二，在使用第一题的方法即可求解。找两数的不同点，常用它的二进制形式

public class Code02_EvenTimesOddTimes {
    public static int getOddTimesNum(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num ^= arr[i]; // 让所有数相异或，根据异或的运算性质，最后一定会留下唯一的奇数
        }
        return num;
    }

    public static int[] getTwiceOddNum(int[] arr) {
        // 将数组中所有数相异或，得到a^b(注意a一定不等于b）
        // 找到a^b二进制形式中最右边的那个1，这代表a和b在这一位上不相同
        // 利用这一点不同，将数组分为两部分，分别将两组数据中所有数相异或，得到a和b

        int[] twiceNum = new int[2];
        int temp = 0, rightOne = 0;
        int a = 0, b = 0;
        for (int i = 0; i < arr.length; i++) {
            temp ^= arr[i];
        }
        rightOne = temp & (-temp); // -temp意为temp取反+1；这个式子可以取得temp中最右边的1
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) == 0) {
                a ^= arr[i];
            } else {
                b ^= arr[i];
            }
        }
        twiceNum[0] = a;
        twiceNum[1] = b;
        Arrays.sort(twiceNum);
        return twiceNum;
    }

    public static int comparator(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) % 2 != 0) {
                return i;
            }
        }
        return -1;
    }

    public static int[] comparator_2(int[] arr) {
        int[] twiceNum = new int[2];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) % 2 != 0) {
                twiceNum[index++] = i;
            }
            if (index == 2) {
                break;
            }
        }
        Arrays.sort(twiceNum);
        return twiceNum;
    }

    public static int[] getRandomArray(int kMax, int mMax, int maxValue) {
        int k = (int) (Math.random() * kMax) + 1;
        int m = (int) (Math.random() * mMax) + 1;
        int mTimes = (int) (Math.random() * 5) + 1;
        int num = 0;
        if (k % 2 == 0) {
            k++;
        }
        if (m % 2 != 0) {
            m++;
        }
        int[] arr = new int[(k + m * mTimes)];
        int i = 0;
        num = (int) (Math.random() * (maxValue + 1));
        for (int j = 0; j < k; j++) {
            arr[i++] = num;
        }
        while (mTimes != 0) {
            num = (int) (Math.random() * (maxValue + 1));
            for (int j = 0; j < m; j++) {
                arr[i++] = num;
            }
            mTimes--;
        }
        return arr;
    }

    public static int[] getRandomArray_2(int kMax, int mMax, int maxValue) {
        int k = (int) (Math.random() * kMax) + 1;
        int m = (int) (Math.random() * mMax) + 1;
        int mTimes = (int) (Math.random() * 5) + 1;
        int num = 0;
        if (k % 2 == 0) {
            k++;
        }
        if (m % 2 != 0) {
            m++;
        }
        int[] arr = new int[(k * 2 + m * mTimes)];
        int i = 0;
        num = (int) (Math.random() * (maxValue + 1));
        for (int j = 0; j < k; j++) {
            arr[i++] = num;
        }
        num = (int) (Math.random() * (maxValue + 1));
        for (int j = 0; j < k; j++) {
            arr[i++] = num;
        }
        while (mTimes != 0) {
            num = (int) (Math.random() * (maxValue + 1));
            for (int j = 0; j < m; j++) {
                arr[i++] = num;
            }
            mTimes--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTimes = 50000;
        boolean success = true;
        int kMax = 10;
        int mMax = 20;
        int maxValue = 10;
        int[] arr = null;
//        int[] arr = {0, 1, 1, 2, 2, 3, 3, 4, 4, 3};
//        for (int i = 0; i < testTimes; i++) {
//            arr = getRandomArray(kMax, mMax, maxValue);
//            if (getOddTimesNum(arr) != comparator(arr)) {
//                success = false;
//                System.out.println(Arrays.toString(arr));
//                System.out.println(getOddTimesNum(arr));
//                System.out.println(comparator(arr));
//                break;
//            }
//        }
        for (int i = 0; i < testTimes; i++) {
            arr = getRandomArray_2(kMax, mMax, maxValue);
            if (!Arrays.equals(getTwiceOddNum(arr), comparator_2(arr))) {
                success = false;
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(getTwiceOddNum(arr)));
                System.out.println(Arrays.toString(comparator_2(arr)));
                break;
            }
        }
        System.out.println(success ? "成功" : "失败");

//        System.out.println(Arrays.toString(getTwiceOddNum(arr)));
//        System.out.println(Arrays.toString(comparator_2(arr)));
    }
}
