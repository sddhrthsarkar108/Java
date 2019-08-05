package concurrency.collecion;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWAL {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> al = new CopyOnWriteArrayList<>();
        al.add("a1");
        al.add("a2");
        al.add("a3");

        Iterator<String> it = al.iterator();

        while (it.hasNext()) {
            String e1 = it.next();
            al.remove(3);
            // throws unsupported exception
            it.remove();
        }
    }
}
