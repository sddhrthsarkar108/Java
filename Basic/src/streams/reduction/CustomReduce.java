package streams.reduction;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class CustomReduce {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);

        // identity – the initial value for an accumulator or a default value if a stream is empty and there is nothing to accumulate;
        //accumulator – a function which specifies a logic of aggregation of elements. As accumulator creates a new value for every step of reducing,
        // the quantity of new values equals to the stream’s size and only the last value is useful. This is not very good for the performance.
        //combiner – a function which aggregates results of the accumulator. Combiner is called only in a parallel mode to reduce results of accumulators from different threads.
        OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);
        reduced.ifPresentOrElse(System.out::println, () -> System.out.println("no value present"));

        System.out.println(list.parallelStream().reduce(1,
                // operation can happen in any thread, so operation must be stateless, associative, non-interfering
                (a, b) -> {
                    System.out.println("accumulator, Current thread: " + Thread.currentThread().getName() + " a: " + a + ", b: " + b);
                    return  a + b;
                }
                )
        );

        System.out.println("*** parallel ***");

        System.out.println(list.parallelStream().reduce(1,
                // operation can happen in any thread, so operation must be stateless, associative, non-interfering
                (a, b) -> {
                    System.out.println("accumulator, Current thread: " + Thread.currentThread().getName() + " a: " + a + ", b: " + b);
                    return  a + b;
                },
                (a, b) -> {
                    System.out.println("Combinator, Current thread: " + Thread.currentThread().getName() + " a: " + a + ", b: " + b);
                    return  a * b;
                }
                )
        );

        System.out.println("*** sequential ***");

        System.out.println(list.stream().reduce(1,
                // operation can happen in any thread, so operation must be stateless, associative, non-interfering
                (a, b) -> {
                    System.out.println("accumulator, Current thread: " + Thread.currentThread().getName() + " a: " + a + ", b: " + b);
                    return  a + b;
                },
                (a, b) -> {
                    System.out.println("Combinator, Current thread: " + Thread.currentThread().getName() + " a: " + a + ", b: " + b);
                    return  a * b;
                }
                )
        );
    }
}
