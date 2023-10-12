package by.nata.priorityqueue.impl;

import by.nata.priorityqueue.api.PriorityQueue;
import by.nata.priorityqueue.util.MaxHeap;

public class MaxPriorityQueue <T extends Comparable<T>> implements PriorityQueue<T> {

    private final MaxHeap<T> maxHeap;

    public MaxPriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void insert(T item) {
        maxHeap.insert(item);
    }

    @Override
    public T peek() {
        return maxHeap.peek();
    }

    @Override
    public T extractFirst() {
        return maxHeap.extractMax();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
