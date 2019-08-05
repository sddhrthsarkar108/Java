package strings;

public class RefTest {
    public static void main(String[] args) {
        System.out.println("sid".equals(new String("sid")));

        System.out.println("sid" == new String("sid"));
    }
}
