package PracticeByZuo.Greedy.class1;

import java.util.Arrays;
import java.util.PriorityQueue;

// 课程表III
// 这里有n门不同的在线课程，按从1到n编号
// 给你一个数组courses
// 其中courses[i]=[durationi, lastDayi]表示第i门课将会持续上durationi天课
// 并且必须在不晚于lastDayi的时候完成
// 你的学期从第 1 天开始
// 且不能同时修读两门及两门以上的课程
// 返回你最多可以修读的课程数目
// 测试链接 : https://leetcode.cn/problems/course-schedule-iii/
public class Code05_CourseScheduleIII {
    public static int scheduleCourse(int[][] courses) {
        // 建立大根堆，将已经选择的课程的持续时间加入到堆中
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>((a, b) -> (b - a));
        // 1.将courses按照lastDayi从小到大排列
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        // 2.用curTime记录当前时间，每选择修一门课就增加curTime
        int curTime = 0;
        // 3.如果选择修一门课使得curTime超过它的截止日期，从堆的顶部逐步去掉已选课程，改变curTime使得可以选择这门课
        for (int[] course : courses) {
            if (curTime + course[0] <= course[1]) {
                bigHeap.offer(course[0]);
                curTime += course[0];
            } else if (!bigHeap.isEmpty() && bigHeap.peek() > course[0]) {
                curTime += course[0] - bigHeap.poll();
                bigHeap.offer(course[0]);
            }
        }
        return bigHeap.size();
    }
}
