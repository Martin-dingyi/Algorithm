package PracticeByZuo;


public class test {
    public static class Employee {
        int company;
        int age;

        public Employee(int c, int a) {
            company = c;
            age = a;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "company=" + company +
                    ", age=" + age +
                    '}';
        }
    }


    public static void main(String[] args) {
        char test = 'a';
        System.out.println((int)test);
    }
}
