package PracticeByZuo.OtherStruct;

import java.util.HashMap;

// 题目：设置一个setAll方法给哈希表，使得哈希表里所有值变为特定值
// 分析：使用时间戳来记录各个数据插入的时间
public class Code01_SetAllHashMap {
    static class SetAllHashMap {
        public HashMap<Integer, int[]> hashMap;
        public int cnt;
        public int setAllTime;
        public int setAllValue;

        public SetAllHashMap () {
            hashMap = new HashMap<>();
            cnt = 0;
            setAllTime = 0;
        }

        public void put (int k, int v) {
            cnt++;
            hashMap.put(k, new int[]{v, cnt});
        }

        public int get (int k) {
            int[] data = hashMap.get(k);
            if (data[1] < setAllTime) {
                return setAllValue;
            } else {
                return data[0];
            }
        }

        public void setAll (int v) {
            cnt++;
            setAllTime = cnt;
            setAllValue = v;
        }
    }

    public static void main(String[] args) {
        SetAllHashMap setAllHashMap = new SetAllHashMap();
        setAllHashMap.put(1, 10);
        setAllHashMap.put(2, 20);
        System.out.println(setAllHashMap.get(1));
        setAllHashMap.setAll(100);
        System.out.println(setAllHashMap.get(1));
        System.out.println(setAllHashMap.get(2));
        setAllHashMap.put(3, 30);
        setAllHashMap.put(2, 10000);
        System.out.println(setAllHashMap.get(3));
        System.out.println(setAllHashMap.get(2));
        System.out.println(setAllHashMap.get(1));
    }
}
