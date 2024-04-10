package PracticeByZuo.SpecialTrick.CheckTheTableToFindTheRules;

// 草一共有n的重量，两只牛轮流吃草，A牛先吃，B牛后吃
// 每只牛在自己的回合，吃草的重量必须是4的幂，1、4、16、64....
// 谁在自己的回合正好把草吃完谁赢，根据输入的n，返回谁赢
public class Code02_EatGrass {
    public static String whoWin(int dawn, String curCow) {
        int m = 1;
        int remainder = dawn;
        while (remainder > 0) {
            remainder = dawn;
            remainder -= m;
            m *= 4;
        }
        m = m >= 16 ? m / 16 : 1;
        dawn -= m;
        if (dawn == 0) {
            return curCow;
        }
        String enemy = curCow.equals("A") ? "B" : "A";
        return whoWin(dawn, enemy);
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 100000; i++) {
//            int dawn = (int) (Math.random() * 250);
//            if (!whoWin(dawn).equals(win2(dawn))) {
//                System.out.println("出错");
//                System.out.println("dawn:" + dawn);
//                System.out.println(whoWin(dawn));
//                System.out.println(win2(dawn));
//                break;
//            }
//        }
        System.out.println(whoWin(34, "A"));
    }

    public static String win2(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "B";
        } else {
            return "A";
        }
    }
}
