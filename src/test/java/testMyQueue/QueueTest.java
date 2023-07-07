package testMyQueue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue test;

    @BeforeEach
    public void init() {
        test = new Queue();
        test.enqueue(0);
        test.enqueue(1);
        test.enqueue(2);
    }

    @Test
    public void dequeueTest() {
        assertEquals(0, test.dequeue());
        assertEquals(1, test.dequeue());
        assertEquals(2, test.dequeue());
    }

    @Test
    public void exceptionDequeueTest() {
        dequeueTest();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> test.dequeue());
        assertEquals("List is empty!", exception.getMessage());
    }

    @Test
    public void dequeueNElementsTest() {
        assertArrayEquals(new int[]{0, 1}, test.dequeue(2));
        assertArrayEquals(new int[]{2}, test.dequeue(1));
    }
    @Test
    public void exceptionDequeueNElementsTest() {
        dequeueTest();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> test.dequeue(1));
        assertEquals("There are not enough elements in the list!", exception.getMessage());
    }

    @Test
    public void sizeTest() {
        assertEquals(3, test.size());
        dequeueTest();                         //here I've deleted all elements from the list, that's why size has to be zero afterwards
        assertEquals(0, test.size());
    }

    @Test
    public void toStringTest () {
        assertEquals("0 1 2 ", test.toString());
        dequeueTest();
        assertEquals("", test.toString());
    }

}