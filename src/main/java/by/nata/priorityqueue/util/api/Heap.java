package by.nata.priorityqueue.util.api;

public interface Heap<T extends Comparable<T>> {
    void insert(T item);

    T peek();

    boolean isEmpty();
}
