package collections.list;

import java.util.Arrays;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 1, 2, 0);
        list.sort(Integer::compareTo);
    }
}
