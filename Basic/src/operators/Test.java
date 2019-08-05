package operators;

public class Test {
    public static void main(String[] args) {
        int i = 0;
        System.out.println(i++ + ++i); // 2
        System.out.println(++i + i++); // 6

        int a = 5+5*2+2*2+(2*3);
        System.out.println(a);
    }
}
