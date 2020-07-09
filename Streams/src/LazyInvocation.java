import java.util.List;
import java.util.Optional;

public class LazyInvocation {
    public static void main(String[] args) {
        /*
        the pipeline executes vertically. In our example the first element of the stream didn't satisfy filter's predicate,
        then the filter() method was invoked for the second element, which passed the filter. Without calling the filter()
        for third element we went down through pipeline to the map() method.
        */
        Optional<String> stream = List.of("d").stream()
                .filter(element -> element.contains("2"))
                .map(String::toUpperCase)
                .findFirst();
    }
}
