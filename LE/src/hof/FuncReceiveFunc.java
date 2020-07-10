package hof;

import java.util.List;
import java.util.function.Predicate;

public class FuncReceiveFunc {
    public static void main(String[] args) {
        totalSelectedValues(List.of(3, 8, 1, 4), e -> e/2 != 0);
    }

    public static int totalSelectedValues(List<Integer> values,
                                          Predicate<Integer> selector) {
        return values.stream()
                .filter(selector)
                .reduce(0, Integer::sum);
    }
}
