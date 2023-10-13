package by.nata.priorityqueue.impl;

import by.nata.priorityqueue.api.PriorityQueue;
import by.nata.priorityqueue.util.MinHeap;

import java.util.Comparator;

public class MinPriorityQueue<T> implements PriorityQueue<T> {

    private final MinHeap<T> minHeap;

    public MinPriorityQueue() {
        minHeap = new MinHeap<>();
    }

    public MinPriorityQueue(Comparator<T> comparator) {
        minHeap = new MinHeap<>(comparator);
    }

    @Override
    public void add(T item) {
        minHeap.insert(item);
    }

    @Override
    public T peek() {
        return minHeap.peek();
    }

    @Override
    public T poll() {
        return minHeap.extractMin();
    }

    @Override
    public boolean isEmpty() {
        return minHeap.isEmpty();
    }
}
