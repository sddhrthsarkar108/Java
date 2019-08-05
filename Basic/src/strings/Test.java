package strings;

public class Test {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(str.substring(0, 0)); // ""
        System.out.println(str.substring(2)); // c
        System.out.println(str.substring(2, 2)); // c
    }
}
