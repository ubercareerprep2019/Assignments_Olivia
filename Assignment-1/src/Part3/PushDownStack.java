package Part3;

import java.util.ArrayList;

/** Class implementation of a push down stack from scratch.
 * Includes basic methods: push, pop, top, isEmpty, and min.
 *
 * @author Olivia Lee
 */

public class PushDownStack {

    //class variables
    //note: push down stack only handles for integer values
    ArrayList<Integer> _stack;
    ArrayList<Integer> _minOrder;
    int _size;

    //constructor for Part3.PushDownStack class
    public PushDownStack() {
        _stack = new ArrayList<>();
        _minOrder = new ArrayList<>();
        _size = 0;
    }

    //getter methods
    public int size() {
        return _size;
    }

    //class methods
    public void push(int n) {
        _stack.add(0, n);
        updateMin(n);
        _size++;
    }

    void updateMin(int n) {
        if (_size == 0) {
            _minOrder.add(n);
        } else {
            for (int i = 0; i < _size; i++) {
                if (n > _minOrder.get(i)) {
                    continue;
                } else {
                    _minOrder.add(i, n);
                    return;
                }
            }
            _minOrder.add(n);
        }
    }

    public int pop() {
        if (_size == 0) {
             throw new Error("Part3.PushDownStack is currently empty");
        }
        _size--;
        int last = _stack.remove(0);
        removeMinList(last);
        return last;
    }

    void removeMinList(int n) {
        _minOrder.remove((Integer) n);
    }

    public int top() {
        return _stack.get(0);
    }

    public boolean isEmpty() {
        return _size == 0;
    }

    public int min() {
        assert _size > 0;

        return _minOrder.get(0);
    }


    public static void main(String[] args) {
//        int[] test = {0,1,2,3};
//        for (int i = 0; i < 4; i++) {
//            System.out.println(test[i]);
//        }
    }
}