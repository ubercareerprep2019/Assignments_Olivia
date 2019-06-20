package Part4;

/** Class implementation of a Singly linked list from scratch.
 * Includes basic methods: push, pop, top, isEmpty, and min.
 *
 * @author Olivia Lee
 */

import java.util.Stack;

class SinglyLinkedList<T> {

    private LLNode _front;
    private LLNode _end;
    private int _size;

    SinglyLinkedList() {
        //creates a dummy node to initialize linked list
        _front = new LLNode<T>(null);
        _end = _front;
        _size = 0;
    }

    //helper node class
    static class LLNode<T> {
        private int visits;
        private T _value;
        private LLNode<T> _next;

        LLNode(T v) {
            _value = v;
            _next = null;
            visits = 0;
        }

        void setNext(LLNode<T> node) {
            if (node != null) {
                node.visit();
            }
            _next = node;
        }

        LLNode next() {
            return _next;
        }

        T value() {
            return _value;
        }

        private void visit() {
            visits++;
        }

        void unvisit() {
            visits--;
        }

        int visitNum() {
            return visits;
        }
    }

    //adds a single node containing data to the end of the list
    void pushBack(LLNode<T> data) {
        _end.setNext(data);
        _end = _end.next();
        _size++;
    }

    //removes a single node from the end of the list
    LLNode<T> popBack() {
        LLNode tracker = _front;
        if (tracker.next() == null) {
            throw new Error("LinkedList is currently empty");
        }
        if (hasCycle()) {
            throw new Error("LinkedList is cyclic, has no end");
        }

        while (tracker.next().next() != null) {
            tracker = tracker.next();
        }
        LLNode<T> ret = tracker.next();
        ret.unvisit();
        tracker.setNext(null);
        _end = tracker;
        _size--;

        return ret;
    }

    //adds a single node containing data to a chosen location in the list.
    //if the index > size, do nothing.
    void insert(int index, LLNode<T> data) {
        if (index > _size) {
            return;
        }
        LLNode tracker = _front;
        while (index != 0) {
            tracker = tracker.next();
            index--;
        }
        LLNode tail = tracker.next();
        tail.unvisit();
        data.setNext(tail);
        tracker.setNext(data);
        _size++;
    }

    //erases a single node at the index location in the list
    void erase(int index) {
        if (index >= size()) {
            return;
        }
        if (index == 0) {
            _front.setNext(null);
        } else {
            LLNode prevNode = elementAt(index - 1);
            prevNode.next().unvisit();
            LLNode tail = prevNode.next().next();
            tail.unvisit();
            prevNode.setNext(tail);
        }
        _size--;
    }

    //returns a single node at the index location in the list
    LLNode<T> elementAt(int index) {
        if (index > _size) {
            return null;
        }
        LLNode tracker = _front;
        while (index > 0) {
            tracker = tracker.next();
            index--;
        }
        return tracker.next();
    }

    //returns the length of the linked list
    int size() {
        return _size;
    }

    boolean hasCycle() {
        LLNode temp = _front;
        while (temp.next() != null) {
            if (temp.visitNum() > 1) {
                return true;
            }
            temp = temp.next();
        }
        return false;
    }

//    0 1 1 0 ; even stop at index 1
    // 0 1 0 ; odd stop at index 1

    // checks if linked list is a palindrome using stack library (flexible for generics)
    boolean isPalindrome() {
        if (size() == 0) {
            throw new Error("Linked list is empty");
        }

        int middle = size()/2;
        LLNode<T> node = _front.next();
        Stack<T> stack = new Stack();

        while (middle != 0) {
            stack.push(node.value());
            node = node.next();
            middle--;
        }
        if (size()%2 != 0) { //odd
            stack.pop();
        }
        while (node != null) {
            T val = stack.pop();
            if (val != node.value()) {
                return false;
            }
            node = node.next();
        }

        return true;
    }
}
