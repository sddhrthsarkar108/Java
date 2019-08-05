package threading.pc;

class Printer {
    private boolean isOddPrinted;

    synchronized void printEven(int number) {
        while (!isOddPrinted) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOddPrinted = false;
        notify();
    }

    synchronized void printOdd(int number) {
        while (isOddPrinted) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isOddPrinted = true;
        notify();
    }
}

class TaskEvenOdd implements Runnable {
    private int max;
    private Printer print;
    private boolean isEvenPrinter;

    TaskEvenOdd(Printer print, int max, boolean isEvenPrinter) {
        this.print = print;
        this.max = max;
        this.isEvenPrinter = isEvenPrinter;
    }

    @Override
    public void run() {
        int number = isEvenPrinter ? 2 : 1;

        while (number <= max) {
            if (isEvenPrinter) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }
}

public class PrintOddEven {
    public static void main(String[] args) {
        Printer print = new Printer();
        new Thread(new TaskEvenOdd(print, 10, false), "Odd").start();
        new Thread(new TaskEvenOdd(print, 10, true), "Even").start();
    }
}
