package streams.reduction;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reduce {
    public static void main(String[] args) {
        int sum = IntStream.range(1, 4).sum();
        long count = IntStream.range(1, 4).count();
        OptionalInt max = IntStream.range(1, 4).max();

        List<String> elements =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"))
                        .collect(Collectors.toList());
        Optional<String> anyElement = elements.stream().findAny();
        Optional<String> firstElement = elements.stream().findFirst();

        boolean anyMatch = elements.stream().anyMatch(val -> val.equals(""));
        boolean noneMatch = elements.stream().noneMatch(val -> val.equals(""));
        boolean allMatch = elements.stream().allMatch(val -> val.equals(""));
    }
}
