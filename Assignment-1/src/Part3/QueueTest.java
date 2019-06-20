package Part3;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/** QueueTest class used as both unit and integration test
 *  for homework part3 package on Queue data structure implementation
 *
 * @author olivialee
 * **/

public class QueueTest {

    Queue _test;

    public void initializeTest() {
        _test = new Queue();
    }

    @Test
    void testEnqueue() {
        initializeTest();
        _test.enqueue(5);
        assertFalse(_test.isEmpty());
    }

    @Test
    void testDequeue() {
        initializeTest();
        for (int i = 5; i > 0; i--) {
            _test.enqueue(i);
        }
        for (int i = 5; i > 0; i--) {
            assertEquals(i, _test.dequeue());
        }
    }
}