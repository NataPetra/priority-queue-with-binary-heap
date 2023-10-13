package by.nata.priorityqueue.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinPriorityQueueTest {

    private MinPriorityQueue<Integer> minPriorityQueue;

    @BeforeEach
    void setUp() {
        minPriorityQueue = new MinPriorityQueue<>();
    }

    @Test
    void testInsertAndPeek() {
        minPriorityQueue.add(5);
        minPriorityQueue.add(10);
        minPriorityQueue.add(2);

        assertEquals(2, minPriorityQueue.peek());
    }

    @Test
    void testExtractFirst() {
        minPriorityQueue.add(5);
        minPriorityQueue.add(10);
        minPriorityQueue.add(2);

        assertEquals(2, minPriorityQueue.poll());
        assertEquals(5, minPriorityQueue.poll());
        assertEquals(10, minPriorityQueue.poll());
    }

    @Test
    void testIsEmpty() {
        assertTrue(minPriorityQueue.isEmpty());
        minPriorityQueue.add(5);
        assertFalse(minPriorityQueue.isEmpty());
        minPriorityQueue.poll();
        assertTrue(minPriorityQueue.isEmpty());
    }

    @Test
    void testWithReverseComparator() {
        MinPriorityQueue<Integer> minPriorityQueueWithComparator = new MinPriorityQueue<Integer>(Comparator.reverseOrder());
        minPriorityQueueWithComparator.add(10);
        minPriorityQueueWithComparator.add(20);
        assertEquals(20, minPriorityQueueWithComparator.peek());
    }

}