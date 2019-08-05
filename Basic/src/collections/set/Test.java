package collections.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        System.out.println(hs.add(null));
        System.out.println(hs.add(null));

        TreeSet<String> ts = new TreeSet<>();
        ts.add(null); // null pointer ex

        Stream.of("One", "Two", "Three", "Four")
                .collect(HashSet::new, Set::add, Set::addAll);
    }
}
