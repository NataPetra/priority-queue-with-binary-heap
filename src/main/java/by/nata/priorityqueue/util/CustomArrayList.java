package by.nata.priorityqueue.util;

import java.util.Arrays;

public class CustomArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    public static final String INDEX_OUT_OF_BOUNDS = "Index out of bounds.";
    private Object[] array;
    private int size;

    public CustomArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    public void set(int index, T element) {
        checkIndex(index);
        array[index] = element;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        checkIndex(index);

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(INDEX_OUT_OF_BOUNDS);
        }
    }
}
