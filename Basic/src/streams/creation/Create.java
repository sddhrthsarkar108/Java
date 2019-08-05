package streams.creation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Create {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        // empty() method is used upon creation to avoid returning null for streams with no element
        Stream<String> stream = list == null  ? Stream.empty() : list.stream();

        // stream of array
        Stream<String> streamOfArray = Stream.of("a", "b", "c");
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

        // When builder is used the desired type should be additionally specified in the right part of the statement,
        // otherwise the build() method will create an instance of the Stream<Object>
        Stream<String> streamBuilder = Stream.<String>builder().add("1").add("2").build();

        // developer should specify the desired size or the generate() method will work until it reaches the memory limit
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);

        // iterate
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

        // primitive stream
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        // from string
        IntStream streamOfChars = "abc".chars();
        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");

        // from file
        try (Stream<String> streamOfStrings = Files.lines(Paths.get(""))) {
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
