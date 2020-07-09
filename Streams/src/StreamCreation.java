import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) throws IOException {
        // ISEMPTY, STREAM: stream from collection or empty stream
        Stream<String> strm = Arrays.asList("a", "b").isEmpty() ? Stream.empty() : Arrays.asList("a", "b").stream();
        strm = Arrays.stream(new String[]{"a", "b", "c"});

        // OF: stream from array
        strm = Stream.of("a", "b", "c");
        strm = Stream.of(new String[] {"a", "b", "c"});

        // BUILDER: desired type of stream should be specified as part of RHS
        strm = Stream.<String>builder().add("a").add("b").build();

        // GENERATE: accepts supplier for infinite stream generation
        strm = Stream.generate(() -> "ex");

        // ITERATE: creates infinite stream generation using seed element and unary operator to create new element
        strm = Stream.iterate("ex", s -> s + " " + s);
        // java 9
        strm = Stream.iterate("ex", s -> s.length() < 100, s -> s + " " + s);
        // java 9
        strm = Stream.ofNullable("");

        // get stream from file
        strm = Files.lines(Paths.get("README.md"));

        // primitive streams
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
        Stream<Long> longStream1 = longStream.boxed();
        intStream = "abc".chars();
    }
}
