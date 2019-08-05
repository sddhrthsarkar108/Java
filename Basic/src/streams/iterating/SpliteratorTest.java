package streams.iterating;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Spliterator sp1 = list.spliterator();
        Spliterator sp2 = sp1.trySplit();

        // returns false if there is no element thus can be used for loop control
        sp1.tryAdvance(System.out::println);
        sp2.forEachRemaining(System.out::println);
    }
}
