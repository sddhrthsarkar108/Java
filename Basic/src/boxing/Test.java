package boxing;

public class Test {
    public static void main(String[] args) {
        Integer i1 = 1;
        Integer i2 = 2;

        System.out.println(i1 == i2);

        Integer i3 = Integer.valueOf(3);
        Integer i4 = Integer.valueOf(4);

        System.out.println(i3 == i4);

        Integer i5 = new Integer(5);
        Integer i6 = new Integer(6);

        System.out.println(i5 == i6);
        System.out.println(i1 == 1);
    }
}
