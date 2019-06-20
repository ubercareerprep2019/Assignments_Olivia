package Part3;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/** PushDownStackTest class used as both unit and integration test
 *  for homework part3 package on Stack data structure implementation
 *
 * @author olivialee
 * **/

class PushDownStackTest {

    PushDownStack testStack;

    public void init() {
        testStack = new PushDownStack();
    }

    @Test
    public void testPush() {
        init();
        testStack.push(0);
        assertEquals(0, testStack.top());
    }

    @Test
    public void testPop() {
        init();
        testStack.push(0);
        assertEquals(0, testStack.top());
        int topVal = -1;
        try {
            topVal = testStack.pop();
        } catch (Exception e){
            System.out.println("Error: Stack should not be empty");
        }
        assertEquals(0, topVal);
    }

    @Test
    void testisEmpty() {
        init();
        for (int i = 0; i < 5; i++) {
            testStack.push(i);
        }
        assertFalse(testStack.isEmpty());
        for (int i = 0; i < 5; i++) {
            testStack.pop();
        }
        assertTrue(testStack.isEmpty());
    }

    @Test
    void testMin() {
        init();
        int[] toAdd = {5,3,10,6,2,8};
        for (int i = 0; i < toAdd.length; i++) {
            int n = toAdd[i];
            testStack.push(n);
        }
        int minimum = testStack.min();
        assertEquals(2, minimum);
    }

}
