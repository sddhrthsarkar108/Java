import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {
        Optional<String> opStrr1 = List.of("d").stream().max(String::compareToIgnoreCase); // min
        opStrr1.map(n -> n).orElseGet(() -> "");
        int totalLength = List.of("d").stream().mapToInt(String::length).sum();
        long noOfElem = List.of("d").stream().count();

        // concat stream
        Stream.concat(opStrr1.stream(), opStrr1.stream());

        List<String> elements = List.of("a", "b", "c", "d", "e", "f");
        // it will most likely return the first element in the Stream but there is no guarantee for this.
        Optional<String> anyElement = elements.stream().findAny();
        Optional<String> firstElement = elements.stream().findFirst();

        boolean anyMatch = elements.stream().anyMatch(val -> val.equals(""));
        boolean noneMatch = elements.stream().noneMatch(val -> val.equals(""));
        boolean allMatch = elements.stream().allMatch(val -> val.equals(""));
    }
}
