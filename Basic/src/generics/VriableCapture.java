package generics;

import java.util.List;

class WildCardError {
    void foo(List<?> list) {
        // compiler is not able to confirm the type of object that is being inserted into the list,
        // and an error is produced.
        // list.set(0, list.get(0));
    }
}

class CaptureWildCard {
    void foo(List<?> list) {
        fooHelper(list);
    }

    private <T> void fooHelper(List<T> list) {
        list.set(0, list.get(0));
    }
}

public class VriableCapture {
}
