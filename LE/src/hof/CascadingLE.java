package hof;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class CascadingLE {
    public static void main(String[] args) {
//        Function<Integer, Predicate<Integer>> isGreaterThan = (Integer pivot) -> {
//            Predicate<Integer> isGreaterThanPivot = (Integer candidate) -> {
//                return candidate > pivot;
//            };
//
//            return isGreaterThanPivot;
//        };

        Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> candiate -> candiate > pivot;

        List<Integer> numbers1 = List.of(2, 4, 5, 1);

//        List<Integer> valuesOver25 = numbers1.stream()
//                .filter(e ->  e > 25).collect(toList());
//        List<Integer> valuesOver50 = numbers1.stream()
//                .filter(e -> e > 50)
//                .collect(toList());
//        List<Integer> valuesOver75 = numbers1.stream()
//                .filter(e -> e > 75)
//                .collect(toList());

        List<Integer> valuesOver25 = numbers1.stream()
                .filter(isGreaterThan.apply(25))
                .collect(toList());
        List<Integer> valuesOver50 = numbers1.stream()
                .filter(isGreaterThan.apply(50))
                .collect(toList());
        List<Integer> valuesOver75 = numbers1.stream()
                .filter(isGreaterThan.apply(75))
                .collect(toList());
    }
}
