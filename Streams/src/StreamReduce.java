import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamReduce {
    public static void main(String[] args) {
        // accumulator
        OptionalInt opInt =  IntStream.range(1, 5).reduce(Integer::sum);

        // identity (to be returned for empty streams) + accumulator
        String result = List.of("a", "b", "c").stream().reduce("initial value: ",
            // operation can happen in any thread, so operation must be stateless, associative, non-interfering
            (a, b) -> {
                System.out.println("accumulator, Current thread: " + Thread.currentThread().getName() + " 1st: " + a + ", 2nd: " + b);
                return  a + b;
            },
            (a, b) -> {
            // won't run for sequencila stream
                System.out.println("combiner, Current thread: " + Thread.currentThread().getName() + " 1st: " + a + ", 2nd: " + b);
                return String.join("_", a, b);
            }
        );
        System.out.println("sequential: " + result);
        result = List.of("a", "b", "c").parallelStream().reduce("initial value: ",
            // operation can happen in any thread, so operation must be stateless, associative, non-interfering
            (a, b) -> {
                System.out.println("accumulator, Current thread: " + Thread.currentThread().getName() + " 1st: " + a + ", 2nd: " + b);
                return  a + b;
            },
            (a, b) -> {
                System.out.println("combiner, Current thread: " + Thread.currentThread().getName() + " 1st: " + a + ", 2nd: " + b + ", result: " + (a.length() + b.length()));
                return String.join("_", a, b);
            }
        );
        System.out.println("parallel: " + result);
    }
}
