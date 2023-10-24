package by.nata.priorityqueue.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinHeapTest {

    private MinHeap<Integer> minHeap;

    @BeforeEach
    public void setUp() {
        minHeap = new MinHeap<>();
    }

    @Test
    void testAddAndPeek() {
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(8);

        assertEquals(2, minHeap.peek());
    }

    @Test
    void testPoll() {
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(8);
        minHeap.add(12);
        minHeap.add(1);
        minHeap.add(19);

        assertEquals(1, minHeap.poll());
        assertEquals(2, minHeap.poll());
        assertEquals(5, minHeap.poll());
        assertEquals(8, minHeap.poll());
        assertEquals(12, minHeap.poll());
        assertEquals(19, minHeap.poll());
        assertTrue(minHeap.isEmpty());
    }

    @Test
    void testAddNull() {
        assertThrows(IllegalArgumentException.class, () -> minHeap.add(null));
    }

    @Test
    void testPollEmptyHeap() {
        assertTrue(minHeap.isEmpty());
        assertNull(minHeap.poll());
    }

    @Test
    void testIsEmpty() {
        assertTrue(minHeap.isEmpty());
        minHeap.add(10);
        assertFalse(minHeap.isEmpty());
        minHeap.poll();
        assertTrue(minHeap.isEmpty());
    }

    @Test
    void testSiftDownWithSingleChild() {
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(2);

        minHeap.poll();

        assertEquals(5, minHeap.poll());
        assertEquals(10, minHeap.peek());
    }

    @Test
    void testAddDuplicates() {
        minHeap.add(5);
        minHeap.add(5);
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(2);

        assertEquals(2, minHeap.poll());
        assertEquals(2, minHeap.poll());
        assertEquals(5, minHeap.poll());
        assertEquals(5, minHeap.poll());
        assertEquals(5, minHeap.poll());
        assertEquals(10, minHeap.poll());
        assertTrue(minHeap.isEmpty());
    }

    @Test
    void testAddWithComparator() {
        MinHeap<String> stringMinHeap = new MinHeap<>(Comparator.comparingInt(String::length));

        stringMinHeap.add("apple");
        stringMinHeap.add("banana");
        stringMinHeap.add("cherry");

        assertEquals("apple", stringMinHeap.poll());
        assertEquals("cherry", stringMinHeap.poll());
        assertEquals("banana", stringMinHeap.poll());
        assertTrue(stringMinHeap.isEmpty());
    }

    @Test
    void testAddWithDefaultComparator() {
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);

        assertEquals(5, minHeap.poll());
        assertEquals(10, minHeap.poll());
        assertEquals(20, minHeap.poll());
        assertTrue(minHeap.isEmpty());
    }

    @Test
    void testAddWithCustomComparator() {
        MinHeap<Integer> customMinHeap = new MinHeap<>((a, b) -> b - a);

        customMinHeap.add(10);
        customMinHeap.add(5);
        customMinHeap.add(20);

        assertEquals(20, customMinHeap.poll());
        assertEquals(10, customMinHeap.poll());
        assertEquals(5, customMinHeap.poll());
        assertTrue(customMinHeap.isEmpty());
    }

    @Test
    void testPollWithComparables() {
        MinHeap<ComparableTestClass> comparableHeap = new MinHeap<>();

        comparableHeap.add(new ComparableTestClass(3));
        comparableHeap.add(new ComparableTestClass(1));
        comparableHeap.add(new ComparableTestClass(5));

        assertEquals(1, comparableHeap.poll().value());
        assertEquals(3, comparableHeap.poll().value());
        assertEquals(5, comparableHeap.poll().value());
    }

    @Test
    void testAddNonComparableWithNullComparator() {
        MinHeap<NonComparable> noComparableHeap = new MinHeap<>(null);
        NonComparable nonComparable = new NonComparable(42);
        assertThrows(IllegalArgumentException.class, () -> noComparableHeap.add(nonComparable));
    }

    @Test
    void testAddNullWithNullComparator() {
        assertThrows(IllegalArgumentException.class, () -> minHeap.add(null));
    }

    @Test
    void testAddNullWithDefaultComparator() {
        MinHeap<Integer> integerMinHeap = new MinHeap<>();
        assertThrows(IllegalArgumentException.class, () -> integerMinHeap.add(null));
    }


    private record ComparableTestClass(int value) implements Comparable<ComparableTestClass> {

        @Override
        public int compareTo(ComparableTestClass o) {
            return Integer.compare(this.value, o.value);
        }
    }

    private record NonComparable(int value) {
    }

}