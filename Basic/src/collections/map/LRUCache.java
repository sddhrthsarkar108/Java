package collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<k, v> extends LinkedHashMap<k, v> {
    private int capacity;

    LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        // Create the cache with capacity 2
        LRUCache<Integer, Integer> cache = new LRUCache<>(
                2);

        cache.put(2, 1); // Will add an element with key as 2 and value as 1
        cache.put(3, 2); // Will add an element with key as 3 and value as 2

        // Will add an element with key as 4 and value as 3. Also will remove
        // the element with key 2 as it was added least recently and cache can
        // just have two elements at a time
        cache.put(4, 3);

        // Since element with key 2 was removed, it will return null
        System.out.println(cache.get(2));

        // It will return value 2 and move the element with key 3 to the head.
        // After this point, element with key 4 will be least recently accessed
        System.out.println(cache.get(3));

        // Will add an element with key as 5 and value as 4. Also will remove
        // the element with key 4 as it was accessed least recently and cache
        // can just have two elements at a time
        cache.put(5, 4);

        // Since element with key 2 was removed, it will return null
        System.out.println(cache.get(4));
    }
}
