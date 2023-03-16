package ru.markush.lessonTwo.arrayList;

import java.util.Iterator;

public class CustomArrayList<T> implements Iterable<T> {
    private final int INIT_SIZE = 10;
    private final Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    public void add(T item) {
        array[pointer++] = item;
    }

    /**
     * Тут я подглядел
     */
    public T get(int index) {
        return (T) array[index];

    }


    public void remove(int index) {
        for (int i = index; i < pointer; i++) {
            array[i] = array[i + 1];
        }
        array[pointer] = null;
        pointer--;
    }

    public int size() {
        return pointer;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < INIT_SIZE && array[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) array[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }
}