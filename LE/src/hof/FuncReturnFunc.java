package hof;

import java.util.List;
import java.util.function.Predicate;

public class FuncReturnFunc {
    public static void main(String[] args) {
        createIsOdd().test(4);
    }

    public static Predicate<Integer> createIsOdd() {
        Predicate<Integer> check = number -> number % 2 != 0;
        return check;
    }
}
