package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Flatmap {
    public static void main(String[] args) {
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        // a map operation wraps its return value inside its ordinal type while flatMap does not.
        // So after mapping, one needs to unwrap (read “flatten”) the object to retrieve the value whereas, after flat mapping,
        List<String> phones = people.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
