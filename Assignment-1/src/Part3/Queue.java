package Part3;/* Class implementation of a Part3.Queue using the push down stack from Part 3A.
 * First in, first out data structure.
 * Includes basic methods: enqueue, dequeue, and init.
 *
 * @author Olivia Lee
 */

public class Queue extends PushDownStack {

    public Queue() {
        super();
    }

    public void enqueue(int n) {
        push(n);
    }

    public int dequeue() {
        return pop();
    }

    public int pop() {
        if (_size == 0) {
            throw new Error("Part3.Queue is currently empty.");
        }
        _size--;
        int last = _stack.remove(_size);
        removeMinList(last);
        return last;
    }

    public int top() {
        return _stack.get(_size);
    }
}
