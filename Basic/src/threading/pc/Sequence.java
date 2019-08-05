package threading.pc;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sequence {
    private static int number = 0;
    private static final int PRINT_NUMBERS_UPTO = 10;
    private static final Object lock = new Object();

    static class SequentialThread implements Runnable {
        int sequence;
        int noOfThreads;
        String name;

        SequentialThread(String name, int sequence, int noOfThreads) {
            this.name = name;
            this.sequence = sequence;
            this.noOfThreads = noOfThreads;
        }

        @Override
        public void run() {
            while (number < PRINT_NUMBERS_UPTO) {
                synchronized (lock) {
                    while (number % noOfThreads != sequence) { // wait for numbers other than remainder
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(name + ", value " + number);
                    number++;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        int noOfThreads = 3;
        ExecutorService es = Executors.newFixedThreadPool(noOfThreads);

        for (int i = 0; i < noOfThreads; i++) {
            es.execute(new SequentialThread("T" + (i + 1), i, noOfThreads));
        }

        es.shutdown();
    }
}
