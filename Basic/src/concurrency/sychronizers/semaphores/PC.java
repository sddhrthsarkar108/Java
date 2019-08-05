package concurrency.sychronizers.semaphores;

import java.util.concurrent.Semaphore;

class Q {
    private int i;
    private Semaphore semCon = new Semaphore(0);
    private Semaphore semProd = new Semaphore(1);

    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {

        }

        System.out.println("put :" + n);
        this.i = n;
        semCon.release();
    }

    int get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {

        }

        System.out.println("got: " + i);
        semProd.release();
        return i;
    }
}

public class PC {
    public static void main(String[] args) {
        Q q =  new Q();

        new Thread(() -> {
            int i = 0;

            while(i<10) {
                q.put(++i);
            }

        }, "producer").start();

        new Thread(() -> {
            int i = 0;

            while(i<10) {
                i=q.get();
            }
        }, "consumer").start();
    }
}
