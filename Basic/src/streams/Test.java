package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.stream().forEach(System.out::println);

        // throws ConcurrentModificationException
        list.stream().forEach(n -> list.add(2, 4));
    }
}
