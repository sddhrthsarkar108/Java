package collections.Queues;

import java.util.*;

public class LRUCache {
    class Element {
        private String value;
        private Date timestamp;

        Date getTimestamp() {
            return timestamp;
        }
        String getValue() {
            return value;
        }
        void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }
        void setValue(String value) {
            this.value = value;
        }
    }

    private static final int SIZE = 5;
    private Map<String, String> map = new HashMap<String, String>();
    private PriorityQueue<Element> pq = new PriorityQueue<Element>(SIZE,  Comparator.comparing(Element::getTimestamp)    );

    private void insert(Element e) {
        System.out.println("Received Element: " + e.getValue());
        pq.offer(e);
    }

    private String remove() {
        Element leastUsed = pq.poll();
        if (leastUsed != null) {
            System.out.println("Removing least used element:" + leastUsed.getValue());
            System.out.println("This element was last used:" + leastUsed.getTimestamp());
            return leastUsed.getValue();
        }
        return "";
    }

    private void update(String mostRecentEleKey) {
        //update priority queue with most recent access.
        //Internal data structure on PriorityQueue is Heap and it is partially sorted.
        //This means, any update on elements means to delete them and add them again.
        Iterator<Element> pqIterator = pq.iterator();
        while (pqIterator.hasNext()) {
            Element e = pqIterator.next();
            if (e.getValue().equals(mostRecentEleKey)) {
                pqIterator.remove();
                break;
            }
        }
        Element mostRecent = new Element();
        mostRecent.setTimestamp(new Date());
        mostRecent.setValue(mostRecentEleKey);
        insert(mostRecent);
    }

    public String get(String key) {
        String value = map.get(key);
        if (!"".equals(value)) {
            System.out.println("Updating " + key + " with current timestamp.");
            update(key);
        }
        return value;
    }

    public void put(String key, String value) {
        System.out.println("Before put opertaion, map size:" + map.size());
        if (map.containsKey(key)) {
            System.out.println("Cache hit on key:" + key + ", nothing to insert!");
            update(key);
        } else {
            if (map.size() >= SIZE) {
                String leastUsedKey = remove();
                map.remove(leastUsedKey);
            }
            System.out.println("Element not present in Cache: " + key);
            Element e = new Element();
            e.setValue(key);
            e.setTimestamp(new Date());
            insert(e);
            map.put(key, value);
        }
        System.out.println("After put operation, following stats are generated:");
        System.out.println("Least used element:" + pq.peek().getValue() + ", last used at:" + pq.peek().getTimestamp());
        System.out.println("map size:" + map.size());
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache();
        cache.put("a", "a");
        cache.put("b", "b");
        cache.put("c", "c");
        cache.put("d", "d");
        cache.put("e", "e");
        cache.put("b", "b");
        cache.put("d", "d");
        cache.put("b", "b");
        cache.put("c", "c");
        cache.put("b", "b");
        cache.put("a", "a");
        cache.put("f", "f");
        cache.get("a");
    }
}