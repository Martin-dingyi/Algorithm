package ByMartinPratice.其他数据结构;

import java.util.ArrayList;
import java.util.HashMap;

// 题目：插入、删除和获取随机元素O(1)时间的结构
public class Code03_InsertDeleteRandom {
    static class RandomizedSet {
        HashMap<Integer, Integer> hashMap;
        ArrayList<Integer> arr;

        public RandomizedSet() {
            hashMap = new HashMap<>();
            arr = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (hashMap.containsKey(val)) {
                return false;
            }
            hashMap.put(val, arr.size());
            arr.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!hashMap.containsKey(val)) {
                return false;
            }
            int index = hashMap.get(val);
            arr.set(index, arr.get(arr.size() - 1));
            hashMap.put(arr.get(arr.size() - 1), index);
            arr.remove(arr.size() - 1);
            hashMap.remove(val);
            return true;
        }

        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(1);
        rs.insert(2);
        rs.insert(3);
        rs.insert(4);
        System.out.println(rs.insert(5));

        System.out.println(rs.remove(3));

        System.out.println(rs.getRandom());
    }
}
