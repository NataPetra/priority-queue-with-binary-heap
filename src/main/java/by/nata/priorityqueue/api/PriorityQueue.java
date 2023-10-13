package by.nata.priorityqueue.api;

public interface PriorityQueue<T> {

    void add(T item);

    T peek();

    T poll() throws IllegalStateException;

    boolean isEmpty();
}
