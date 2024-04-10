package ByMartinPratice.杂类.打表找规律;

public class Code03_IsSumOfConsecutiveNumbers {
    public static boolean isSeqSum(int num) {
        int factor = (num + 1) / 2;
        for (int i = factor; i > 0; i--) {
            if (mdy(num, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean mdy(int num, int factor) {
        if (num == 0) {
            return true;
        }
        if (num < 0 || factor == 0) {
            return false;
        }
        return mdy(num - factor, factor - 1);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + "：" + isSeqSum(i));
        }
        System.out.println(isSeqSum(12));
    }
}
