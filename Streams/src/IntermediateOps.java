import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        int totalLength = List.of("d").stream()
                .skip(2)
                .limit(3)
                .distinct()
                .sorted()
                // This method exists mainly to support debugging, where you want to see the elements as they flow past a certain point in a pipeline
                .peek(System.out::println)
                .filter(String::isEmpty)
                .map(String::toUpperCase)
                .mapToInt(String::length).sum();

        List<List<String>> complexList = List.of(List.of("a", "b"), List.of("c", "d"));
        Stream<String> flattedStream =  complexList.stream().flatMap(List::stream);

        // for unordered stream output is non deterministic
        // it's expensive to use takeWhile with parallel streams
        // emulate break statement
        Set<Integer> numbers = Set.of(2, 4, 6, 3, 8);
        numbers.stream()
                .takeWhile(n -> n % 2 == 0) // dropWhile
                .forEach(System.out::println);
    }
}
