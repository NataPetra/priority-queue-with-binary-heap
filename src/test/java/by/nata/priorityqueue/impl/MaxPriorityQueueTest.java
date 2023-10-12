package by.nata.priorityqueue.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MaxPriorityQueueTest {

    private MaxPriorityQueue<Integer> maxPriorityQueue;

    @BeforeEach
    void setUp() {
        maxPriorityQueue = new MaxPriorityQueue<>();
    }

    @Test
    void testInsertAndPeek() {
        maxPriorityQueue.insert(5);
        maxPriorityQueue.insert(10);
        maxPriorityQueue.insert(2);

        assertEquals(10, maxPriorityQueue.peek());
    }

    @Test
    void testExtractFirst() {
        maxPriorityQueue.insert(5);
        maxPriorityQueue.insert(10);
        maxPriorityQueue.insert(2);

        assertEquals(10, maxPriorityQueue.extractFirst());
        assertEquals(5, maxPriorityQueue.extractFirst());
        assertEquals(2, maxPriorityQueue.extractFirst());
    }

    @Test
    void testIsEmpty() {
        assertTrue(maxPriorityQueue.isEmpty());
        maxPriorityQueue.insert(5);
        assertFalse(maxPriorityQueue.isEmpty());
        maxPriorityQueue.extractFirst();
        assertTrue(maxPriorityQueue.isEmpty());
    }

    @Test
    void testPeekOnEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> maxPriorityQueue.peek());
    }

    @Test
    void testExtractFirstOnEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> maxPriorityQueue.extractFirst());
    }

    @Test
    void testExtractFirstOnEmptyQueueAfterInsert() {
        maxPriorityQueue.insert(5);
        maxPriorityQueue.extractFirst();
        assertThrows(IllegalStateException.class, () -> maxPriorityQueue.extractFirst());
    }

}