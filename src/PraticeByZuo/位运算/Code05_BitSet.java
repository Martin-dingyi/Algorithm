package ByMartinPratice.位运算;

import java.util.HashSet;

/*
 * 题目：实现位图，其中有增删改查四个功能。位图指的是将一组连续的数字存储在几个二进制数中
 * 比如存储0~500，一个int类型有32位，可以存0~31，总共需要16个int类型来存储。用二进制一个位
 * 中的0表示这个数不存在位图中，1表示存在。
 * */
public class Code05_BitSet {
    public static class bitSet {
        public int[] set;

        public bitSet(int n) {
            // Code02_BinaryTreeTraversal/b向上取整的方法：(Code02_BinaryTreeTraversal+b-1)/b
            // 一个int类型可以存32个数,总共需要n/32（向上取整）个int类型数
            set = new int[(n + 31) / 32];
        }

        public void add(int value) {
            int index = value / 32;
            set[index] |= 1 << (value % 32);
        }

        public void delete(int value) {
            set[value / 32] &= ~(1 << (value % 32));
        }

        public void reverse(int value) {
            set[value / 32] ^= (1 << (value % 32));
        }

        public boolean contain(int value) {
            return (set[value / 32] & (1 << (value % 32))) != 0;
        }
    }

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        int n = 500000;
        bitSet bs = new bitSet(n);
        for (int i = 0; i < n; i++) {
            double possible = Math.random();
            int value = (int) (Math.random() * n);
            if (possible < 0.33) {
                hashSet.add(value);
                bs.add(value);
            } else if (possible < 0.66) {
                hashSet.remove(value);
                bs.delete(value);
            } else {
                bs.reverse(value);
                if (hashSet.contains(value)) {
                    hashSet.remove(value);
                } else {
                    hashSet.add(value);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (hashSet.contains(i) != bs.contain(i)) {
                System.out.println("出错了");
                break;
            }
        }
        System.out.println("结束了");
    }
}
