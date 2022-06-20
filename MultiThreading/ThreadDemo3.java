package MultiThreading;

public class ThreadDemo3 {
    public static void main(String[] args) {
        TestThread3 t = new TestThread3();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}

class TestThread3 implements Runnable {
    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tickets--;
                System.out.println(Thread.currentThread().getName() + " is selling ticket " + tickets);

            } else {
                break;
            }
        }
    }
}