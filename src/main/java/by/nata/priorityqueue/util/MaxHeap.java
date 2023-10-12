package by.nata.priorityqueue.util;

import by.nata.priorityqueue.util.api.Heap;

/**
 * This class represents a MaxHeap, which is a data structure that maintains the maximum element
 * at the top of the heap. It implements the Heap interface and can be used to create a priority
 * queue with the maximum element as the highest priority.
 *
 * @param <T> The type of elements stored in the MaxHeap. It should implement the Comparable interface
 *           to enable comparison of elements.
 */
public class MaxHeap<T extends Comparable<T>> implements Heap<T> {

    private final CustomArrayList<T> heap;

    /**
     * Constructs a new MaxHeap.
     */
    public MaxHeap() {
        heap = new CustomArrayList<>();
    }

    /**
     * Inserts a new element into the MaxHeap.
     *
     * @param item The element to be inserted. Must not be null.
     * @throws IllegalArgumentException if the provided element is null.
     */
    @Override
    public void insert(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Null elements are not allowed.");
        }
        heap.add(item);
        siftUp(heap.size() - 1);
    }

    /**
     * Returns the maximum element in the MaxHeap without removing it.
     *
     * @return The maximum element in the MaxHeap.
     * @throws IllegalStateException if the MaxHeap is empty.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty. Cannot peek.");
        }
        return heap.get(0);
    }

    /**
     * Extracts and removes the maximum element from the MaxHeap.
     *
     * @return The maximum element that was removed.
     * @throws IllegalStateException if the MaxHeap is empty.
     */
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

    /**
     * Checks if the MaxHeap is empty.
     *
     * @return true if the MaxHeap is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        T currentItem = heap.get(index);

        while (index > 0 && currentItem.compareTo(heap.get(parentIndex)) > 0) {
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
        if (i == j) {
            return;
        }

        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
