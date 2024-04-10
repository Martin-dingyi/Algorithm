package MartinByZuo.其他数据结构;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// 题目：插入、删除和获取随机元素O(1)时间且允许有重复数字的结构
public class Code04_InsertDeleteRandomDuplicatesAllowed {
    static class RandomizedCollection {
        HashMap<Integer, HashSet<Integer>> map;
        ArrayList<Integer> arr;

        public RandomizedCollection() {
            map = new HashMap<>();
            arr = new ArrayList<>();
        }

        public boolean insert(int val) {
            HashSet<Integer> set;
            if (map.containsKey(val)) {
                set = map.get(val);
                set.add(arr.size());
                map.put(val, set);
                arr.add(val);
                return false;
            } else {
                set = new HashSet<>();
                set.add(arr.size());
                map.put(val, set);
                arr.add(val);
                return true;
            }
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            HashSet<Integer> set = map.get(val);
            // 使用迭代器在set中随便选一个数据
            int index = set.iterator().next();
            int lastVal = arr.get(arr.size() - 1);
            set.remove(index);
            if (set.isEmpty()) {
                map.remove(val);
            }
            if (index == arr.size() - 1) {
                arr.remove(index);
                return true;
            }
            set = map.get(lastVal);
            arr.set(index, lastVal);
            set.remove(arr.size() - 1);
            arr.remove(arr.size() - 1);
            set.add(index);
            return true;
        }

        public int getRandom() {
            return arr.get((int) (Math.random() * arr.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        rc.insert(10);
        rc.insert(10);
        rc.insert(20);
        rc.insert(20);
        rc.insert(30);
        rc.insert(30);

        rc.remove(10);
        rc.remove(20);
        rc.insert(20);

        rc.insert(10);

        rc.remove(30);
        rc.insert(40);
        rc.remove(30);
        rc.insert(30);
    }
}
