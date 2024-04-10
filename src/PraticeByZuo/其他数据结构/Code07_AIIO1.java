package ByMartinPratice.其他数据结构;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

// 题目：全O(1)的数据结构，实现增删、获取最大和最小值
// 分析：使用双向链表记录数的大小
public class Code07_AIIO1 {
    static class AllOne {
        static class Bucket {
            int cnt;
            Bucket next, last;
            HashSet<String> set;

            public Bucket(int cnt) {
                this.cnt = cnt;
                next = null;
                last = null;
                set = new HashSet<>();
            }

            // 将结点插到pre之后
            public void insert(Bucket pre, Bucket bucket) {
                bucket.next = pre.next;
                pre.next.last = bucket;
                pre.next = bucket;
                bucket.last = pre;
            }

            public void remove(Bucket bucket) {
                bucket.last.next = bucket.next;
                bucket.next.last = bucket.last;
                bucket.next = null;
                bucket.last = null;
            }
        }

        Bucket Min, Max;
        HashMap<String, Bucket> map;

        public AllOne() {
            Min = new Bucket(0);
            Max = new Bucket(Integer.MAX_VALUE);
            Min.set.add("");
            Max.set.add("");
            Min.next = Max;
            Max.last = Min;
            map = new HashMap<>();
        }

        public void inc(String key) {
            if (map.containsKey(key)) {
                // 如果key已经存在，说明key需要在链表中往后移动一格
                Bucket bucket = map.get(key);
                // 如果后面一个桶存在，就把字符串往后放，否则新建一个桶
                if ((bucket.next.cnt == bucket.cnt + 1) && bucket.next != Max) {
                    bucket.next.set.add(key);
                } else {
                    // 如果后面一个桶不存在，创建一个出来
                    Bucket temp = new Bucket(bucket.cnt + 1);
                    temp.set.add(key);
                    Min.insert(bucket, temp);
                }
                map.put(key, bucket.next);
                bucket.set.remove(key);
                if (bucket.set.isEmpty()) {
                    // 如果桶空了，从链表中移除这个桶
                    Min.remove(bucket);
                }
            } else {
                // 如果key不存在，说明第一次进入桶
                // 先查看cnt为1的桶是否存在
                if (Min.next.cnt != 1) {
                    Bucket temp = new Bucket(1);
                    temp.set.add(key);
                    Min.insert(Min, temp);
                } else {
                    Min.next.set.add(key);
                }
                map.put(key, Min.next);
            }
        }

        public void dec(String key) {
            if (!map.containsKey(key)) {
                return;
            } else {
                Bucket bucket = map.get(key);
                // 如果bucket的前方有结点，直接把key放到前面
                if (bucket.last != Min && (bucket.last.cnt == bucket.cnt - 1)) {
                    bucket.last.set.add(key);
                } else {
                    // 没有结点，创造一个结点
                    if (bucket.cnt == 1) {
                        map.remove(key);
                    } else {
                        Bucket temp = new Bucket(bucket.cnt - 1);
                        temp.set.add(key);
                        Min.insert(bucket.last, temp);
                    }

                }
                bucket.set.remove(key);
                map.put(key, bucket.last);
                if (bucket.set.isEmpty()) {
                    // 如果桶空了，从链表中移除这个桶
                    Min.remove(bucket);
                }
            }
        }

        public String getMaxKey() {
            return Max.last.set.iterator().next();
        }

        public String getMinKey() {
            return Min.next.set.iterator().next();
        }
    }

    public static void main(String[] args) {
        AllOne ao = new AllOne();
        ao.inc("hello");
        ao.inc("hello");
        ao.inc("leet");
//        ao.inc("b");
//        ao.inc("b");
//        ao.dec("b");
//        ao.dec("b");
        System.out.println(ao.getMaxKey());
        System.out.println(ao.getMinKey());
    }
}
