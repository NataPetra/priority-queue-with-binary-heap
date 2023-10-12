package by.nata.priorityqueue.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MaxHeapTest {

    private MaxHeap<Integer> maxHeap;

    @BeforeEach
    void setUp() {
        maxHeap = new MaxHeap<>();
    }

    @Test
    void testInsertAndPeek() {
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(2);

        assertEquals(10, maxHeap.peek());
    }

    @Test
    void testExtractMax() {
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(2);

        assertEquals(10, maxHeap.extractMax());
        assertEquals(5, maxHeap.extractMax());
        assertEquals(2, maxHeap.extractMax());
    }

    @Test
    void testIsEmpty() {
        assertTrue(maxHeap.isEmpty());
        maxHeap.insert(5);
        assertFalse(maxHeap.isEmpty());
        maxHeap.extractMax();
        assertTrue(maxHeap.isEmpty());
    }

    @Test
    void testPeekOnEmptyHeap() {
        assertThrows(IllegalStateException.class, () -> maxHeap.peek());
    }

    @Test
    void testExtractMaxOnEmptyHeap() {
        assertThrows(IllegalStateException.class, () -> maxHeap.extractMax());
    }

    @Test
    void testExtractMaxOnEmptyHeapAfterInsert() {
        maxHeap.insert(5);
        maxHeap.extractMax();
        assertThrows(IllegalStateException.class, () -> maxHeap.extractMax());
    }

    @Test
    void testSiftUp() {
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(2);
        maxHeap.insert(8);

        assertEquals(10, maxHeap.peek());
    }

    @Test
    void testSiftDown() {
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(2);
        maxHeap.insert(8);

        maxHeap.extractMax();

        assertEquals(8, maxHeap.peek());
    }

    @Test
    void testInsertNullElement() {
        assertThrows(IllegalArgumentException.class, () -> maxHeap.insert(null));
    }

    @Test
    void testExtractMaxFromEmptyHeap() {
        assertThrows(IllegalStateException.class, () -> maxHeap.extractMax());
    }

    @Test
    void testSiftDownWithSingleChild() {
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(2);

        maxHeap.extractMax();

        assertEquals(5, maxHeap.extractMax());
        assertEquals(2, maxHeap.peek());
    }

    @Test
    void testLargeInserts() {
        for (int i = 100; i >= 1; i--) {
            maxHeap.insert(i);
        }

        for (int i = 100; i >= 1; i--) {
            assertEquals(i, maxHeap.extractMax());
        }
    }

    @Test
    void testInsertWithDuplicateElements() {
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(10);
        maxHeap.insert(2);
        maxHeap.insert(7);
        maxHeap.insert(2);

        assertEquals(10, maxHeap.extractMax());
        assertEquals(10, maxHeap.extractMax());
        assertEquals(7, maxHeap.extractMax());
        assertEquals(5, maxHeap.extractMax());
        assertEquals(2, maxHeap.extractMax());
        assertEquals(2, maxHeap.extractMax());
        assertTrue(maxHeap.isEmpty());
    }

}