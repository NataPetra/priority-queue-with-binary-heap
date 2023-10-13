package by.nata.priorityqueue.util;

import by.nata.priorityqueue.util.api.Heap;

import java.util.Comparator;

/**
 * This class represents a generic MinHeap, a specialized binary heap data structure
 * where the parent node is smaller than or equal to its children.
 *
 * @param <T> The type of elements stored in the MinHeap.
 */
public class MinHeap<T> implements Heap<T> {
    private final CustomArrayList<T> heap;
    private final Comparator<T> comparator;

    /**
     * Default comparator class for elements in the MinHeap.
     *
     * @param <T> The type of elements to compare.
     */
    private static class DefaultComparator<T> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            if (o1 instanceof Comparable && o2 instanceof Comparable) {
                return ((Comparable<T>) o1).compareTo(o2);
            } else {
                throw new IllegalArgumentException("Objects are not Comparable");
            }
        }
    }

    /**
     * Constructs a new MinHeap with the default comparator based on natural ordering.
     */
    public MinHeap() {
        this(new DefaultComparator<>());
    }

    /**
     * Constructs a new MinHeap with the specified comparator.
     *
     * @param comparator The comparator used to compare elements in the MinHeap.
     */
    public MinHeap(Comparator<T> comparator) {
        heap = new CustomArrayList<>();
        this.comparator = comparator;
    }

    /**
     * Inserts an element into the MinHeap.
     *
     * @param item The element to insert.
     * @throws IllegalArgumentException if the element is null or not comparable.
     */
    @Override
    public void insert(T item) {
        if (item != null) {
            if (comparator != null || item instanceof Comparable<?>) {
                heap.add(item);
                siftUp(heap.size() - 1);
            } else {
                throw new IllegalArgumentException("Item must implement Comparable or provide a Comparator.");
            }
        } else {
            throw new IllegalArgumentException("Null elements are not allowed.");
        }
    }

    /**
     * Retrieves the minimum element from the MinHeap without removing it.
     *
     * @return The minimum element, or null if the MinHeap is empty.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    /**
     * Extracts and removes the minimum element from the MinHeap.
     *
     * @return The minimum element, or null if the MinHeap is empty.
     * @throws IllegalStateException if the MinHeap is empty.
     */
    public T extractMin() throws IllegalStateException {
        if (isEmpty()) {
            return null;
        }

        T min = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        if (!isEmpty()) {
            siftDown();
        }
        return min;
    }

    /**
     * Checks if the MinHeap is empty.
     *
     * @return true if the MinHeap is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;
        T currentItem = heap.get(index);

        while (index > 0) {
            T parentItem = heap.get(parentIndex);
            if (comparator.compare(currentItem, parentItem) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            } else {
                break;
            }
        }
    }

    private void siftDown() {
        int size = heap.size();
        int index = 0;

        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallest = index;

            if (leftChildIndex < size && (comparator.compare(heap.get(leftChildIndex), heap.get(smallest)) < 0)) {
                    smallest = leftChildIndex;
            }

            if (rightChildIndex < size && (comparator.compare(heap.get(rightChildIndex), heap.get(smallest)) < 0)) {
                    smallest = rightChildIndex;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
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
