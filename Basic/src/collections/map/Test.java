package collections.map;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        TreeMap<String, String> tm = new TreeMap<>(String::compareTo);
        LinkedHashMap<String, String> lhm = new LinkedHashMap<>(100, 0.75f, true);
    }
}
