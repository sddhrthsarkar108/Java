import java.util.List;
import java.util.Spliterator;

public class StreamIteration {
    public static void main(String[] args) {
        // For parallel stream pipelines, this operation does not guarantee to respect the encounter order of the stream
        List.of("").stream().parallel().forEach(System.out::print);
        System.out.println();
        // Performing the action for one element happens-before  performing the action for subsequent elements,
        // but for any given element, the action may be performed in whatever thread the library chooses.
        List.of("").stream().parallel().forEachOrdered((n) ->  {
            System.out.println(Thread.currentThread().getName());
        });

        // spliterator
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        Spliterator sp1 = list.spliterator();
        Spliterator sp2 = sp1.trySplit();

        // returns false if there is no element thus can be used for loop control
        sp1.tryAdvance(System.out::println);
        sp2.forEachRemaining(System.out::println);
    }
}
