package by.nata.priorityqueue.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MinHeapTest {

    private MinHeap<Integer> minHeap;

    @BeforeEach
    void setUp() {
        minHeap = new MinHeap<>();
    }

    @Test
    void testInsertAndPeek() {
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(2);

        assertEquals(2, minHeap.peek());
    }

    @Test
    void testExtractMix() {
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(2);

        assertEquals(2, minHeap.extractMin());
        assertEquals(5, minHeap.extractMin());
        assertEquals(10, minHeap.extractMin());
    }

    @Test
    void testIsEmpty() {
        assertTrue(minHeap.isEmpty());
        minHeap.insert(5);
        assertFalse(minHeap.isEmpty());
        minHeap.extractMin();
        assertTrue(minHeap.isEmpty());
    }

    @Test
    void testPeekOnEmptyHeap() {
        assertThrows(IllegalStateException.class, () -> minHeap.peek());
    }

    @Test
    void testExtractMixOnEmptyHeap() {
        assertThrows(IllegalStateException.class, () -> minHeap.extractMin());
    }

    @Test
    void testExtractMixOnEmptyHeapAfterInsert() {
        minHeap.insert(5);
        minHeap.extractMin();
        assertThrows(IllegalStateException.class, () -> minHeap.extractMin());
    }

    @Test
    void testSiftUp() {
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(2);
        minHeap.insert(8);

        assertEquals(2, minHeap.peek());
    }

    @Test
    void testSiftDown() {
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(2);
        minHeap.insert(8);

        minHeap.extractMin();

        assertEquals(5, minHeap.peek());
    }

    @Test
    void testInsertNullElement() {
        assertThrows(IllegalArgumentException.class, () -> minHeap.insert(null));
    }

    @Test
    void testExtractMixFromEmptyHeap() {
        assertThrows(IllegalStateException.class, () -> minHeap.extractMin());
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
    void testLargeInserts() {
        for (int i = 100; i >= 1; i--) {
            minHeap.insert(i);
        }

        for (int i = 1; i <= 100; i++) {
            assertEquals(i, minHeap.extractMin());
        }
    }
}