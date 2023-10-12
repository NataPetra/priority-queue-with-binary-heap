package by.nata.priorityqueue.api;

public interface PriorityQueue<T extends Comparable<T>> {

    void insert(T item);

    T peek();

    T extractFirst() throws IllegalStateException;

    boolean isEmpty();
}
