package by.nata.priorityqueue.util;

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
    void testInsertAndPeek() {
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(8);

        assertEquals(2, minHeap.peek());
    }

    @Test
    void testExtractMin() {
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(8);
        minHeap.insert(12);
        minHeap.insert(1);
        minHeap.insert(19);

        assertEquals(1, minHeap.extractMin());
        assertEquals(2, minHeap.extractMin());
        assertEquals(5, minHeap.extractMin());
        assertEquals(8, minHeap.extractMin());
        assertEquals(12, minHeap.extractMin());
        assertEquals(19, minHeap.extractMin());
        assertTrue(minHeap.isEmpty());
    }

    @Test
    void testInsertNull() {
        assertThrows(IllegalArgumentException.class, () -> minHeap.insert(null));
    }

    @Test
    void testExtractMinEmptyHeap() {
        assertTrue(minHeap.isEmpty());
        assertNull(minHeap.extractMin());
    }

    @Test
    void testIsEmpty() {
        assertTrue(minHeap.isEmpty());
        minHeap.insert(10);
        assertFalse(minHeap.isEmpty());
        minHeap.extractMin();
        assertTrue(minHeap.isEmpty());
    }

    @Test
    void testSiftDownWithSingleChild() {
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(2);

        minHeap.extractMin();

        assertEquals(5, minHeap.extractMin());
        assertEquals(10, minHeap.peek());
    }

    @Test
    void testInsertDuplicates() {
        minHeap.insert(5);
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(2);

        assertEquals(2, minHeap.extractMin());
        assertEquals(2, minHeap.extractMin());
        assertEquals(5, minHeap.extractMin());
        assertEquals(5, minHeap.extractMin());
        assertEquals(5, minHeap.extractMin());
        assertEquals(10, minHeap.extractMin());
        assertTrue(minHeap.isEmpty());
    }

    @Test
    void testInsertWithComparator() {
        MinHeap<String> stringMinHeap = new MinHeap<>(Comparator.comparingInt(String::length));

        stringMinHeap.insert("apple");
        stringMinHeap.insert("banana");
        stringMinHeap.insert("cherry");

        assertEquals("apple", stringMinHeap.extractMin());
        assertEquals("cherry", stringMinHeap.extractMin());
        assertEquals("banana", stringMinHeap.extractMin());
        assertTrue(stringMinHeap.isEmpty());
    }

    @Test
    void testInsertWithDefaultComparator() {
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);

        assertEquals(5, minHeap.extractMin());
        assertEquals(10, minHeap.extractMin());
        assertEquals(20, minHeap.extractMin());
        assertTrue(minHeap.isEmpty());
    }

    @Test
    void testInsertWithCustomComparator() {
        MinHeap<Integer> customMinHeap = new MinHeap<>((a, b) -> b - a);

        customMinHeap.insert(10);
        customMinHeap.insert(5);
        customMinHeap.insert(20);

        assertEquals(20, customMinHeap.extractMin());
        assertEquals(10, customMinHeap.extractMin());
        assertEquals(5, customMinHeap.extractMin());
        assertTrue(customMinHeap.isEmpty());
    }

    @Test
    void testExtractMinWithComparables() {
        MinHeap<ComparableTestClass> comparableHeap = new MinHeap<>();

        comparableHeap.insert(new ComparableTestClass(3));
        comparableHeap.insert(new ComparableTestClass(1));
        comparableHeap.insert(new ComparableTestClass(5));

        assertEquals(1, comparableHeap.extractMin().value());
        assertEquals(3, comparableHeap.extractMin().value());
        assertEquals(5, comparableHeap.extractMin().value());
    }

    @Test
    void testInsertNonComparableWithNullComparator() {
        MinHeap<NonComparable> noComparableHeap = new MinHeap<>(null);
        NonComparable nonComparable = new NonComparable(42);
        assertThrows(IllegalArgumentException.class, () -> noComparableHeap.insert(nonComparable));
    }

    @Test
    void testInsertNullWithNullComparator() {
        assertThrows(IllegalArgumentException.class, () -> minHeap.insert(null));
    }

    @Test
    void testInsertNullWithDefaultComparator() {
        MinHeap<Integer> integerMinHeap = new MinHeap<>();
        assertThrows(IllegalArgumentException.class, () -> integerMinHeap.insert(null));
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