package collections.list;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class Java8Test {

    // for immutable list via FP in java 8
    static class ImmutableListCollector {
        static <t> Collector<t, List<t>, List<t>> toImmutableList() {
            return Collector.of(ArrayList::new, List::add, (left, right) -> {
                left.addAll(right);
                return left;
            }, Collections::unmodifiableList);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        IntStream.of(1, 2, 3, 4).forEach(list::add);

        list.removeIf(i -> i == 3);

        PrimitiveIterator.OfInt iit = list.stream().mapToInt(Integer::intValue).iterator();
        //iit.forEachRemaining(n -

        list.spliterator().tryAdvance(System.out::println);

        list.stream().collect(ImmutableListCollector.toImmutableList());
    }
}
