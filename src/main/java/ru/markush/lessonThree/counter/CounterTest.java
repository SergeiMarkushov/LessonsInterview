package ru.markush.lessonThree.counter;

public class CounterTest {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(counter.getCount());
        }
    }
    /**
     * Thread Thread-0 incrementing count to 1
     * Thread Thread-1 incrementing count to 2
     * Thread Thread-0 incrementing count to 3
     * Thread Thread-1 incrementing count to 4
     * Thread Thread-0 incrementing count to 5
     * .........
     * .........
     * Thread Thread-0 incrementing count to 98
     * Thread Thread-0 incrementing count to 99
     * Thread Thread-0 incrementing count to 100
     * 100
     */
}