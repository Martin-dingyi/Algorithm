package MartinByZuo.其他数据结构;

import java.util.ArrayList;
import java.util.HashMap;

// 题目：最大频率栈，频率最大的，离顶最近的优先出栈
// 分析：使用含链表的栈来实现，离顶越近的链表，其中的元素频率越大；链表尾部的元素离栈顶最近。
public class Code06_MaximumFrequencyStack {
    class FreqStack {

        HashMap<Integer, ArrayList<Integer>> map;
        HashMap<Integer, Integer> counts;
        int topFrequency;

        public FreqStack() {
            map = new HashMap<>();
            counts = new HashMap<>();
            topFrequency = 0;
        }

        public void push(int val) {
            if (counts.containsKey(val)) {
                counts.put(val, counts.get(val) +1);
            } else {
                counts.put(val, 1);
            }
            int frequency = counts.get(val);
            topFrequency = Math.max(frequency, topFrequency);
            if (map.containsKey(frequency)) {
                map.get(frequency).add(val);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(val);
                map.put(frequency, arr);
            }

        }

        public int pop() {
            ArrayList<Integer> arr = map.get(topFrequency);
            int ans = arr.remove(arr.size() - 1);
            if (arr.isEmpty()) {
                map.remove(topFrequency--);
            }
            counts.put(ans, counts.get(ans) - 1);
            return ans;
        }
    }
}
