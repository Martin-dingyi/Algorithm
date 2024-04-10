package ByMartinPratice.二分答案法;

// 机器人跳跃问题
// 机器人正在玩一个古老的基于DOS的游戏
// 游戏中有N+1座建筑，从0到N编号，从左到右排列
// 编号为0的建筑高度为0个单位，编号为i的建筑的高度为H(i)个单位
// 起初机器人在编号为0的建筑处
// 每一步，它跳到下一个（右边）建筑。假设机器人在第k个建筑，且它现在的能量值是E
// 下一步它将跳到第个k+1建筑
// 它将会得到或者失去正比于与H(k+1)与E之差的能量
// 如果 H(k+1) > E 那么机器人就失去H(k+1)-E的能量值，否则它将得到E-H(k+1)的能量值
// 游戏目标是到达第个N建筑，在这个过程中，能量值不能为负数个单位
// 现在的问题是机器人以多少能量值开始游戏，才可以保证成功完成游戏

import java.io.*;

// 测试链接 : https://www.nowcoder.com/practice/7037a3d57bbd4336856b8e16a9cafd71
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过
public class Code03_RobotPassThroughBuilding {

    public static int MAXN = 100001;

    public static int[] arr = new int[MAXN];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            int max = 0;
            for (int i = 1; i <= n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
                max = Math.max(max, arr[i]);
            }
            out.println(getPassThroughEnergy(arr, max));
        }
        out.flush();
        out.close();
        br.close();
    }

    public static int getPassThroughEnergy(int[] h, int max) {
        int ans = -1;
        int left = 0, right = max;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (canPass(h, mid, max)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static boolean canPass(int[] h, int energy, int max) {
        for (int val : h) {
            if (energy >= val) {
                energy += energy - val;
            } else {
                energy -= val - energy;
            }
            if (energy >= max) {
                return true;
            }
            if (energy < 0) {
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        int[] h = {3, 4, 3, 2, 4};
//        System.out.println(getPassThroughEnergy(h, 4));
//    }

}
