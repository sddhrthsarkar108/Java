package threading.interview;

public class TSys extends Thread {
    TSys(String s) {
        super(s);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new TSys("");
        Thread t2 = new TSys("");

        t1.join();
        t2.join();
    }

    @Override
    public void run() {
        System.out.println("thread running");
    }
}
