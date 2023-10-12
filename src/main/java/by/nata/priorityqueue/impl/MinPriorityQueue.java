package by.nata.priorityqueue.impl;

import by.nata.priorityqueue.api.PriorityQueue;
import by.nata.priorityqueue.util.MinHeap;

public class MinPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    private final MinHeap<T> minHeap;

    public MinPriorityQueue() {
        minHeap = new MinHeap<>();
    }

    @Override
    public void insert(T item) {
        minHeap.insert(item);
    }

    @Override
    public T peek() {
        return minHeap.peek();
    }

    @Override
    public T extractFirst() {
        return minHeap.extractMin();
    }

    @Override
    public boolean isEmpty() {
        return minHeap.isEmpty();
    }
}
