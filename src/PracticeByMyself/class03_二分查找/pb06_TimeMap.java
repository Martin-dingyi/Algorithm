package PracticeByMyself.class03_二分查找;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author mdy
 * @date 2024-12-13 11:05
 * @description <a href="https://leetcode.cn/problems/time-based-key-value-store/">...</a>
 */
public class pb06_TimeMap {


    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("a", "mdy", 1);
        obj.set("b", "李家豪", 2);
//        obj.set("c", "钟建明", 3);
//        obj.set("d", "给予饭", 4);
        System.out.println(obj.get("c", 5));
    }

    static class TimeMap {


        private final HashMap<String, List<Entry>> entryMap;

        public TimeMap() {
            entryMap = new HashMap<>();
        }

        static class Entry {
            public Entry(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }

            String value;

            int timestamp;

        }

        public void set(String key, String value, int timestamp) {
            List<Entry> entries = new ArrayList<>();
            Entry entry = new Entry(value, timestamp);
            entries.add(entry);
            entries = entryMap.putIfAbsent(key, entries);
            if (entries != null) {
                entries.add(entry);
            }
        }

        public String get(String key, int timestamp) {

            List<Entry> entryList = entryMap.get(key);

            if (entryList == null) {
                return "";
            }

            int left = 0;
            int right = entryList.size() - 1;
            int mid;
            int targetIndex = -1;
            // 在数组中找到比当前timestamp小的所有entry，然后取最大的那个

            while (left <= right) {

                mid = (left + right) >> 1;
                if (timestamp >= entryList.get(mid).timestamp) {
                    targetIndex = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (targetIndex != -1) {
                return entryList.get(targetIndex).value;
            }

            return "";
        }
    }
}
