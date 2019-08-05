package threading.pc;

class Q {
    private int i;
    private boolean valueSet = false;

    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        System.out.println("put :" + n);
        this.i = n;
        valueSet = true;
        notifyAll();
    }

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        System.out.println("get: " + i);
        valueSet = false;
        notifyAll();
        return i;
    }
}

public class PC {
    public static void main(String[] args) {
        Q q = new Q();
        new Thread(() -> {
            int i = 0;

            while (i < 10) {
                q.put(++i);
            }

        }, "producer").start();
        new Thread(() -> {
            int i = 0;

            while (i < 10) {
                i = q.get();
            }
        }, "consumer").start();
    }
}
