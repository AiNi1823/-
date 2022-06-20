package MultiThreading;

public class ThreaDemo1 {

    public static void main(String[] args) {
        TestThread1 thread3 = new TestThread1();
        Thread t = new Thread(thread3);
        t.start();
        while (true) {
            System.out.println("main thread is running.");
            try {
                Thread.sleep(1000); //1000毫秒
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class TestThread1 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is running.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
