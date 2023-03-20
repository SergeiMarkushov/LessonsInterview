package ru.markush.lessonThree.counter;

public class CounterTest {
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.increment();
        counter.increment();
        System.out.println(counter.getCount());
        counter.decrement();
        System.out.println(counter.getCount());
    }
}
