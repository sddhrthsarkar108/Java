package collections.list;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();

        al.ensureCapacity(100);
        al.trimToSize();
        al.toArray();

        LinkedList<String> ll = new LinkedList<>();
        ll.addFirst(""); // exception
        ll.offerFirst("");

        ll.removeFirst(); // exception
        ll.pollFirst();

        Iterator<String> it = al.iterator();

        while (it.hasNext()) {
            it.next();
            it.remove();
        }

        ListIterator<String> li = al.listIterator();

        while (li.hasPrevious()) {
            li.set("");
        }
    }
}
