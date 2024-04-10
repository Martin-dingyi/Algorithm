package PracticeByZuo.BitOperation;


import java.util.*;

// 题目：一种数出现K次，其他数出现M次（M>1，M>K），求出现K次的数
/*
    思路：找出出现K次数和M次数的不同点，一般方法为将它们化为二进制进行观察
    出现M次的数，二进制的某一位全部加起来必然为M的倍数
    如果把出现K次的数也算进去，那么那一位取余如果为0，则表示出现K次的数二进制中那一位也为0
    反之如果取余不为0，那么二进制那一位必然为1
 */
public class Code03_KM {
    public static int getKTimesNum(int[] arr, int K, int M) {
        int[] binaryArr = new int[32]; // 我们讨论的范围是int，而int类型的数有32位
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 32; j++) {
                binaryArr[j] += (arr[i] >> j) & 1; // 取出一个二进制数中每一位，加到binary数组中的相应位置
            }
        }
        for (int i = 0; i < 32; i++) {
            if (binaryArr[i] % M != 0) {
                num += (1 << i);
            }
        }
        return num;
    }

    public static int comparator(int[] arr, int K, int M) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) == K) {
                return i;
            }
        }
        return -1;
    }

    public static int[] getRandomArr(int maxValue, int K, int M) {
        int mTimes = (int) (Math.random() * 10) + 1;
        int index = 0;
        int[] arr = new int[K + mTimes * M];
        int kNum = 0;
        int mNum = 0;
        kNum = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
        for (int i = 0; i < K; i++) {
            arr[index++] =  kNum;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < mTimes; i++) {
            do {
                mNum = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
            } while(kNum == mNum || set.contains(mNum));
            set.add(mNum);
            for (int j = 0; j < M; j++) {
                arr[index++] = mNum;
            }
        }

        // 打乱数组
        int randomIndex = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            randomIndex = (int)(Math.random() * arr.length);
            temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int K = 0;
        int M = 0;
        int maxValue = 10;
        boolean success = true;
        int[] arr;
        for (int i = 0; i < testTime; i++) {
            K = (int) (Math.random() * 5) + 1;
            do {
                M = (int) (Math.random() * 10) + 1;
            } while (K >= M);
            arr = getRandomArr(maxValue, K, M);
            if (getKTimesNum(arr, K, M) != comparator(arr, K, M)) {
                success = false;
                System.out.println("K:" + K);
                System.out.println("M:" + M);
                System.out.println(Arrays.toString(arr));
                System.out.println(getKTimesNum(arr, K, M));
                System.out.println(comparator(arr, K, M));
                break;
            }
        }
        System.out.println(success ? "成功" : "失败");
//        System.out.println(Arrays.toString(getRandomArr(10, 2, 3)));

    }
}
