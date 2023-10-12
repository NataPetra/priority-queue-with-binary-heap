package by.nata.priorityqueue.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinPriorityQueueTest {

    private MinPriorityQueue<Integer> minPriorityQueue;

    @BeforeEach
    void setUp() {
        minPriorityQueue = new MinPriorityQueue<>();
    }

    @Test
    void testInsertAndPeek() {
        minPriorityQueue.insert(5);
        minPriorityQueue.insert(10);
        minPriorityQueue.insert(2);

        assertEquals(2, minPriorityQueue.peek());
    }

    @Test
    void testExtractFirst() {
        minPriorityQueue.insert(5);
        minPriorityQueue.insert(10);
        minPriorityQueue.insert(2);

        assertEquals(2, minPriorityQueue.extractFirst());
        assertEquals(5, minPriorityQueue.extractFirst());
        assertEquals(10, minPriorityQueue.extractFirst());
    }

    @Test
    void testIsEmpty() {
        assertTrue(minPriorityQueue.isEmpty());
        minPriorityQueue.insert(5);
        assertFalse(minPriorityQueue.isEmpty());
        minPriorityQueue.extractFirst();
        assertTrue(minPriorityQueue.isEmpty());
    }

    @Test
    void testPeekOnEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> minPriorityQueue.peek());
    }

    @Test
    void testExtractFirstOnEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> minPriorityQueue.extractFirst());
    }

    @Test
    void testExtractFirstOnEmptyQueueAfterInsert() {
        minPriorityQueue.insert(5);
        minPriorityQueue.extractFirst();
        assertThrows(IllegalStateException.class, () -> minPriorityQueue.extractFirst());
    }

}