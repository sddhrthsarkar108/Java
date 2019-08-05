package streams.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomCollect {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);

        list.stream().map(Integer::bitCount).collect(Collectors.toList());

        list.stream().map(Integer::bitCount).collect(LinkedList::new,
                LinkedList::add,
                LinkedList::addAll);

        list.stream().map(Integer::bitCount).collect(
                () -> {
                    System.out.println("creating container");
                    return new LinkedList<>();
                },
                (l, e) -> {
                    System.out.println("adding element: " + e);
                    l.add(e);
                },
                // won't run for sequential stream
                (l1, l2) -> {
                    System.out.println("concat lists");
                    l1.addAll(l2);
                });

        System.out.println("*** parallel ***");

        list.parallelStream().map(Integer::bitCount).collect(
                () -> {
                    System.out.println("creating container");
                    return new LinkedList<>();
                },
                (l, e) -> {
                    System.out.println("adding element: " + e);
                    l.add(e);
                },
                (l1, l2) -> {
                    System.out.println("concat lists");
                    l1.addAll(l2);
                });
    }
}
