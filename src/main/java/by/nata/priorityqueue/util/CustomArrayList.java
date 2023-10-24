package by.nata.priorityqueue.util;

import java.util.Arrays;

/**
 * This class implements a custom dynamic array that can store elements of generic type T.
 *
 * @param <T> The type of elements stored in the CustomArrayList.
 */
public class CustomArrayList<T> {

    private static final int DEFAULT_CAPACITY = 8;
    public static final String INDEX_OUT_OF_BOUNDS = "Index out of bounds.";
    private T[] array;
    private int size;

    /**
     * Constructs a new CustomArrayList with the default initial capacity.
     */
    public CustomArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Adds an element to the CustomArrayList.
     *
     * @param element The element to be added.
     */
    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    /**
     * Gets the element at the specified index.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    /**
     * Sets the element at the specified index to the provided value.
     *
     * @param index   The index of the element to set.
     * @param element The new value to set at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public void set(int index, T element) {
        checkIndex(index);
        array[index] = element;
    }

    /**
     * Returns the number of elements in the CustomArrayList.
     *
     * @return The number of elements in the CustomArrayList.
     */
    public int size() {
        return size;
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index The index of the element to remove.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public void remove(int index) {
        checkIndex(index);

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
    }

    /**
     * Checks if the CustomArrayList is empty.
     *
     * @return true if the CustomArrayList is empty, false otherwise.
     */
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
