package by.nata.priorityqueue.util;

import by.nata.priorityqueue.util.api.Heap;

public class MinHeap <T extends Comparable<T>> implements Heap<T> {
    private CustomArrayList<T> heap;

    public MinHeap() {
        heap = new CustomArrayList<>();
    }

    @Override
    public void insert(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Null elements are not allowed");
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

    public T extractMin() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty. Cannot extract minimum.");
        }

        T min = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        if (!isEmpty()) {
            siftDown(0);
        }
        return min;
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void siftDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChildIndex;
        }

        if (smallest != index) {
            swap(index, smallest);
            siftDown(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
