package classes;

import java.util.ArrayList;
import java.util.List;

public final class Immutable {
    private final int i;
    private final List<String> list;

    Immutable(int i, List<String> list) {
        this.i = i;
        this.list = new ArrayList<>(list);
    }

    public int getI() {
        return i;
    }

    public List<String> getList() {
        return new ArrayList<>(list);
    }
}
