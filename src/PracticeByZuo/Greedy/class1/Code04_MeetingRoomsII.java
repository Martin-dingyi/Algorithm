package PracticeByZuo.Greedy.class1;

import java.util.Arrays;
import java.util.PriorityQueue;

// 会议室II
// 给你一个会议时间安排的数组 intervals
// 每个会议时间都会包括开始和结束的时间intervals[i]=[starti, endi]
// 返回所需会议室的最小数量
// 测试链接 : https://leetcode.cn/problems/meeting-rooms-ii/
// 这题就是讲解027，题目2，最多线段重合问题
// 测试链接 : https://www.nowcoder.com/practice/1ae8d0b6bb4e4bcdbf64ec491f63fc37
public class Code04_MeetingRoomsII {
    public static int minMeetingRooms(int[][] meeting) {
        Arrays.sort(meeting, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < meeting.length; i++) {
            while (!smallHeap.isEmpty() && meeting[i][0] >= smallHeap.peek()) {
                // 如果新增的会议开始时间大于等于堆中根代表的时间，则将这个会议从堆中删除
                smallHeap.poll();
            }
            // 每次新增会议，都将它的结束时间入堆
            smallHeap.add(meeting[i][1]);
            ans = Math.max(ans, smallHeap.size());
        }
        return ans;
    }
}
