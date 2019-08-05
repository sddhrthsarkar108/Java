package concurrency.fjp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

class QuickSort<T extends Comparable> extends RecursiveAction {
    private List<T> data;
    private int left;
    private int right;

    public QuickSort(List<T> data) {
        this.data = data;
        this.left = 0;
        this.right = data.size() - 1;
    }

    public QuickSort(List<T> data, int left, int right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            int pivotIndex = left + ((right - left) / 2);
            pivotIndex = partition(pivotIndex);
            invokeAll(new QuickSort<>(data, left, pivotIndex - 1), new QuickSort<>(data, pivotIndex + 1, right));
        }
    }

    private int partition(int pivotIndex) {
        T pivotValue = data.get(pivotIndex);
        swap(pivotIndex, right);

        int j = left;
        for (int i = left; i < right; i++) {
            if (data.get(i).compareTo(pivotValue) <= 0) {
                if (i != j) {
                    swap(i, j);
                }
                j++;
            }
        }

        swap(j, right);
        return j;
    }

    private void swap(int i, int j) {
        T iValue = data.get(i);
        data.set(i, data.get(j));
        data.set(j, iValue);
    }
}

public class RA {
    public static void main(String[] args) {
        final int SIZE = 10000;
        List<Integer> myList = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            int value = (int) (Math.random() * 100);
            myList.add(value);
        }

        QuickSort<Integer> quickSort = new QuickSort<>(myList);
        //ForkJoinPool pool = new ForkJoinPool();
        //pool.invoke(quickSort);
        quickSort.invoke();
    }
}
