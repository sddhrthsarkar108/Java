package concurrency.collecion;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.DoubleAdder;

public class CHM {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(200, 0.75f, 10);
        map.getOrDefault("k", "v1");
        // atomic
        map.compute("k", (k, v) -> "v2");

        // This operation is atomic because updates on DoubleAdder are atomic
        Map<Integer, DoubleAdder> doubleAdderResults = new ConcurrentHashMap<>();
        doubleAdderResults.computeIfAbsent(1, (k) -> new DoubleAdder()).add(1.0);
        // This is not threadsafe or atomic
        // The update of the mutable non-threadsafe value takes place outside the computeIfAbsent() method
        // pointResults.computeIfAbsent(mapKeyZero, (k) -> new MutablePoint(0, 0)).move(10, 40);

        ConcurrentMap<String, Long> populationByCities = new ConcurrentHashMap<>();
        do {
            Long currentValue = populationByCities.get("New York");
            Long newValue = currentValue == null ? 1 : currentValue + 1;
        } while (!populationByCities.replace("New York", 1l, 0l));
    }
}
