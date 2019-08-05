package collections.map;

import java.util.HashMap;
import java.util.Map;

public class DeclaritiveWay {

    static void print(Map<String, String> map) {
        map.forEach((k, v) -> System.out.println("k: " + k + ", v: " + v));
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.compute("1", (k, v) -> {
            System.out.println("compute when no mapping: " + v);
            return null;
        });

        map.putIfAbsent("1", "v1");

        map.compute("1", (k, v) -> v + v);
        print(map);
        System.out.println();

        map.computeIfPresent("1", (k, v) -> v);
        map.computeIfAbsent("1", k -> k);

        System.out.println(map.size());

        map.putIfAbsent("2", "v2");

        print(map);
        System.out.println();

        map.merge("2", "v3", (v1, v2) -> v1 + v2);
        print(map);

        map.replaceAll((k, v) -> map.get(k) + v);
    }
}
