package by.nata.priorityqueue.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomArrayListTest {

    private CustomArrayList<Integer> customArrayList;

    @BeforeEach
    void setUp() {
        customArrayList = new CustomArrayList<>();
    }

    @Test
    void testAddAndGet() {
        customArrayList.add(5);
        customArrayList.add(10);

        assertEquals(5, customArrayList.get(0));
        assertEquals(10, customArrayList.get(1));
    }

    @Test
    void testSet() {
        customArrayList.add(5);
        customArrayList.add(10);

        customArrayList.set(1, 20);

        assertEquals(20, customArrayList.get(1));
    }

    @Test
    void testRemove() {
        customArrayList.add(5);
        customArrayList.add(10);
        customArrayList.add(15);

        customArrayList.remove(1);

        assertEquals(5, customArrayList.get(0));
        assertEquals(15, customArrayList.get(1));
        assertEquals(2, customArrayList.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(customArrayList.isEmpty());
        customArrayList.add(5);
        assertFalse(customArrayList.isEmpty());
        customArrayList.remove(0);
        assertTrue(customArrayList.isEmpty());
    }

    @Test
    void testIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.set(0, 5));
        assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.remove(0));
    }

    @Test
    void testEnsureCapacity() {
        for (int i = 1; i < 16; i++) {
            customArrayList.add(i);
        }

        assertEquals(15, customArrayList.size());
        assertEquals(15, customArrayList.get(14));
    }

    @Test
    void testRemoveLast() {
        customArrayList.add(5);
        customArrayList.add(10);

        customArrayList.remove(1);

        assertEquals(5, customArrayList.get(0));
        assertEquals(1, customArrayList.size());

        customArrayList.remove(0);

        assertEquals(0, customArrayList.size());
        assertTrue(customArrayList.isEmpty());
    }

    @Test
    void testRemoveInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> customArrayList.remove(0));
    }

    @Test
    void testMultipleAddAndRemove() {
        for (int i = 0; i < 10; i++) {
            customArrayList.add(i);
        }

        for (int i = 0; i < 5; i++) {
            customArrayList.remove(0);
        }

        assertEquals(5, customArrayList.size());
        assertEquals(5, customArrayList.get(0));
    }

}