package ru.markush.lessonThree.pingPong;

public class PingPong {
    private static Object lock = new Object();
    private static boolean isPingTurn = true;
    public static void main(String[] args) {
        Thread pingThread = new Thread(new PingRunnable());
        Thread pongThread = new Thread(new PongRunnable());
        pingThread.start();
        pongThread.start();
    }

    static class PingRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (!isPingTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("ping");
                    isPingTurn = false;
                    lock.notifyAll();
                }
            }
        }
    }

    static class PongRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (isPingTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("pong");
                    isPingTurn = true;
                    lock.notifyAll();
                }
            }
        }
    }
}
