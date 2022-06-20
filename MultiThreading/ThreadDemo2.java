package MultiThreading;

public class ThreadDemo2 {
    public static void main(String[] args) {
        new TestThread2().start();
        new TestThread2().start();
        new TestThread2().start();
        new TestThread2().start();
    }
}

class TestThread2 extends Thread {
    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + " is selling  ticket " + tickets);
                tickets = tickets - 1;
            } else {
                break;
            }
        }
    }
}
