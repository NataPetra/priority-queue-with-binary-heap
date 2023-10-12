package by.nata.priorityqueue.util;

import by.nata.priorityqueue.util.api.Heap;

public class MaxHeap <T extends Comparable<T>> implements Heap<T> {

    private final CustomArrayList<T> heap;

    public MaxHeap() {
        heap = new CustomArrayList<>();
    }

    @Override
    public void insert(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Null elements are not allowed.");
        }
        heap.add(item);
        siftUp(heap.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty. Cannot peek.");
        }
        return heap.get(0);
    }

    public T extractMax() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty. Cannot extract maximum.");
        }

        T max = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        if (!isEmpty()) {
            siftDown(0);
        }
        return max;
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void siftDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largest = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(largest)) > 0) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(largest)) > 0) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            swap(index, largest);
            siftDown(largest);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
