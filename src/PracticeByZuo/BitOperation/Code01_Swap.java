package PracticeByZuo.BitOperation;

public class Code01_Swap {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(a);
        System.out.println(b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
