package concurrency.fjp;

import java.util.List;
import java.util.concurrent.RecursiveTask;

class BinarySearch<V extends Comparable> extends RecursiveTask<Integer> {
    private List<V> data;
    V key;
    private int left;
    private int right;

    public BinarySearch(List<V> data, V key) {
        this.data = data;
        this.key = key;
        this.left = 0;
        this.right = data.size() - 1;
    }

    public BinarySearch(List<V> data, int left, V key, int right) {
        this.data = data;
        this.key = key;
        this.left = left;
        this.right = right;
    }

    @Override
    protected Integer compute() {
        if (right >= left) {
            int mid = (left + right) >>> 1; // also works

            // If the element is present at the
            // middle itself
            if (data.get(mid).equals(key))
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (data.get(mid).compareTo(key) > 1)
                return new BinarySearch<>(data, left, key, mid - 1).invoke();

            // Else the element can only be present
            // in right subarray
            //return new BinarySearch<>(data, mid + 1, right, key).invoke();
        }

        // We reach here when element is not present
        // in array
        return null;
    }
}

public class RT {
    public static void main(String[] args) {

    }
}
