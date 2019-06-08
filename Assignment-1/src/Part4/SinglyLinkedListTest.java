package Part4;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> testLL;

    void initBasic() {
        testLL = new SinglyLinkedList<>();
        for (int i = 1; i < 5; i++) {
            SinglyLinkedList.LLNode<Integer> add = new SinglyLinkedList.LLNode<>(i);
            testLL.pushBack(add);
        }
    }

    @Test
    void testPushBackAddsOneNode() {
        testLL = new SinglyLinkedList<>();
        SinglyLinkedList.LLNode<Integer> one = new SinglyLinkedList.LLNode<>(1);
        testLL.pushBack(one);
        assertEquals("pushBack should have created one node with value 1",
                1, testLL.size());
    }

    @Test
    void testPopBackRemovesCorrectNode() {
        testLL = new SinglyLinkedList<>();
        SinglyLinkedList.LLNode<Integer> one = new SinglyLinkedList.LLNode<>(1);
        testLL.pushBack(one);
        int valPopped = testLL.popBack().value();

        assertEquals("only one node, value should be 1",
                1, valPopped);

        initBasic();
        valPopped = testLL.popBack().value();
        assertEquals("back node should have value 4",
                4, valPopped);
    }


    @Test
    void testElementAtReturnNode() {
        initBasic();
        assertEquals(3, (int) testLL.elementAt(2).value());
        assertEquals(1, (int) testLL.elementAt(0).value());
    }

    @Test
    void testElementAtReturnsNoNodeIfIndexDoesNotExist() {
        testLL = new SinglyLinkedList<>();
        assertEquals(null, testLL.elementAt(0));
        assertEquals(null, testLL.elementAt(1));
        initBasic();
        assertEquals(null, testLL.elementAt(10));
    }

    @Test
    void testEraseRemovesCorrectNode() {
        initBasic();
        SinglyLinkedList.LLNode<Integer> corrNode = testLL.elementAt(2);
        testLL.erase(2);

        assertNotEquals(corrNode, testLL.elementAt(2));
    }

    @Test
    void testEraseDoesNothingIfNoNode() {
        initBasic();
        int size = testLL.size();
        testLL.erase(10);

        assertEquals("expect no change to linkedlist", size, testLL.size());
    }

    @Test
    void testSizeReturnsCorrectSize() {
        testLL = new SinglyLinkedList<>();
        assertEquals(0, testLL.size());
        initBasic();
        assertEquals(4, testLL.size());
    }

    @Test
    void testAcyclic() {
        initBasic();
        boolean cycle = testLL.hasCycle();

        assertFalse(cycle);
    }

    @Test
    void testCyclic() {
        initBasic();
        SinglyLinkedList.LLNode front = testLL.elementAt(0);
        testLL.pushBack(front);

        boolean cycle = testLL.hasCycle();
        assertTrue(cycle);
    }
}
