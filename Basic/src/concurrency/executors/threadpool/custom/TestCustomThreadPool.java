package concurrency.executors.threadpool.custom;


class Task implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()
                    +" is executing task.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
};

public class TestCustomThreadPool {
    public static void main(String[] args) throws Exception {
//        ThreadPool threadPool=new ThreadPool(2); //create 2 threads in ThreadPool
//        Runnable task=new Task();
//        threadPool.execute(task);
//        threadPool.execute(task);
//
//        threadPool.shutdown();
    }
}
