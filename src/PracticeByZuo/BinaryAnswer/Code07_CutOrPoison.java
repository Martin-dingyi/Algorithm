package PracticeByZuo.BinaryAnswer;


import PracticeByZuo.ComparatorUtils;

// 刀砍毒杀怪兽问题
// 怪兽的初始血量是一个整数hp，给出每一回合刀砍和毒杀的数值cuts和poisons
// 第i回合如果用刀砍，怪兽在这回合会直接损失cuts[i]的血，不再有后续效果
// 第i回合如果用毒杀，怪兽在这回合不会损失血量，但是之后每回合都损失poisons[i]的血量
// 并且你选择的所有毒杀效果，在之后的回合都会叠加
// 两个数组cuts、poisons，长度都是n，代表你一共可以进行n回合
// 每一回合你只能选择刀砍或者毒杀中的一个动作
// 如果你在n个回合内没有直接杀死怪兽，意味着你已经无法有新的行动了
// 但是怪兽如果有中毒效果的话，那么怪兽依然会在血量耗尽的那回合死掉
// 返回至少多少回合，怪兽会死掉
// 数据范围 :
// 1 <= n <= 10^5
// 1 <= hp <= 10^9
// 1 <= cuts[i]、poisons[i] <= 10^9
// 本题来自真实大厂笔试，找不到测试链接，所以用对数器验证
public class Code07_CutOrPoison {
    public static int killMonster_dp(int[] cuts, int[] poisons, int hp) {
        return f(cuts, poisons, 0, hp, 0);
    }

    public static int f(int[] cuts, int[] poisons, int index, int hp, int poisonSum) {
        if (hp <= 0) {
            return 0;
        }
        if (index == cuts.length) {
            return poisonSum == 0 ? Integer.MAX_VALUE - 1 : (hp + poisonSum - 1) / poisonSum;
        }
        hp -= poisonSum;
        int p1 = 1 + f(cuts, poisons, index + 1, hp - poisons[index], poisonSum + poisons[index]);
        int p2 = 1 + f(cuts, poisons, index + 1, hp - cuts[index], poisonSum);
        return Math.min(p1, p2);
    }

    public static int killMonster_BS(int[] cuts, int[] poisons, int hp) {
        int ans = 0;
        int left = 0, right = hp + 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (computeDamage(cuts, poisons, mid) >= hp) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static int computeDamage(int[] cuts, int[] poisons, int rounds) {
        int damage = 0;
        int n = Math.min(cuts.length, rounds);
        for (int i = 0; i < n; i++) {
            damage += Math.max(cuts[i], (rounds - i) * poisons[i]);
        }
        return damage;
    }

    public static void main(String[] args) {
        ComparatorUtils cp = new ComparatorUtils();
        int textTimes = 500000;
        boolean success = true;
        for (int i = 0; i < textTimes; i++) {
            int[] cuts = cp.generateRandomNoMinusArray(10, 10);
            int[] poisons;
            do {
                poisons = cp.generateRandomNoMinusArray(10, 10);
            } while (cuts.length != poisons.length);

            int hp = (int) (Math.random() * 1000) + 1;
            int ans1 = killMonster_dp(cuts, poisons, hp);
            int ans2 = killMonster_BS(cuts, poisons, hp);
            if (ans1 != ans2) {
                cp.print(cuts);
                cp.print(poisons);
                System.out.println("答案1：" + ans1);
                System.out.println("答案2：" + ans2);
                System.out.println("血量：" + hp);
                success = false;
                break;
            }
        }
        cp.check(success);


        int[] cuts = {10, 3, 5};
        int[] poisons = {1, 2, 3};
        System.out.println(killMonster_dp(cuts, poisons, 20));
        System.out.println(killMonster_BS(cuts, poisons, 20));
    }
}
