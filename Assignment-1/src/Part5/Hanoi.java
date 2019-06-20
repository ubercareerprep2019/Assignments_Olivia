package Part5;
import java.util.ArrayList;

/** Class implementation of a Towers of Part5.Hanoi.
 * Includes basic methods: moveDisk, disksAtRod, numberOfRods.
 *
 * Towers of Part5.Hanoi is a mathematical puzzle where we have three rods and n disks. The objective
of the puzzle is to move the entire stack to another rod, obeying the following simple rules (from
geeksforgeeks.com):
1. Only one disk can be moved at a time.
2. Each move consists of taking the upper disk from one of the stacks and placing it on top
of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
3. No disk may be placed on top of a smaller disk.
 *
 * @author Olivia Lee
 */

class Hanoi {

    private int _diskNum;
    private ArrayList<ArrayList<Disk>> _rod;
    final int RODNUM = 3;

    Hanoi() {
        _diskNum = 3;
        setup();
    }

    Hanoi(int disks) {
        assert disks > 3;

        _diskNum = disks;
        setup();
    }

    void setup() {
        _rod = new ArrayList<>();
        for (int i = 0; i < RODNUM; i++) {
            ArrayList<Disk> rod = new ArrayList<>();
            _rod.add(rod);
        }
        ArrayList<Disk> fromRod = _rod.get(0);
        for (int i = _diskNum; i > 0; i--) {
            Disk d = new Disk(i);
            fromRod.add(d);
        }
    }

    class Disk {
        private int _size;

        Disk(int s) {
            _size = s;
        }

        int getSize() {
            return _size;
        }
    }

    void moveDisk(int startingRod, int destinationRod) {
        //check if disk move is valid otherwise don't move and prompt for next move
        Disk from = seeTopDisk(startingRod);
        Disk to = seeTopDisk(destinationRod);

        if (to != null && from.getSize() > to.getSize()) {
            throw new Error("Invalid move: starting rod disk is larger than destination");
        } else {
            stackDisk(startingRod, destinationRod);
        }
    }

    ArrayList<Disk> disksAtRod(int rodIndex) {
        return _rod.get(rodIndex);
    }

    int numberOfDisks() {
        return _diskNum;
    }

    Disk seeTopDisk(int rodIndex) {
        int size = _rod.get(rodIndex).size();
        if (size == 0) {
            return null;
        }
        return _rod.get(rodIndex).get(size - 1);
    }

    Disk getTopDisk(int rodIndex) {
        int size = _rod.get(rodIndex).size();
        return _rod.get(rodIndex).remove(size - 1);
    }

    void stackDisk(int startRod, int destinationRod) {
        Disk d = getTopDisk(startRod);
        _rod.get(destinationRod).add(d);
    }


    int spareRod(int startRod, int destinationRod) {
        if (startRod == 0) {
            if (destinationRod == 1) {
                return 2;
            }
            return 1;
        }
        if (startRod == 1) {
            if (destinationRod == 0) {
                return 2;
            }
            return 0;
        }
        if (startRod == 2) {
            if (destinationRod == 0) {
                return 1;
            }
            return 0;
        }
        return -1;
    }

    void solveHanoi(int numDisks, int fromPeg, int toPeg) {
        // base case:  no disks to move
        if (numDisks == 0) {
            return;
        }
        // recursive case:
        int spareRod = spareRod(fromPeg, toPeg);
        solveHanoi(numDisks - 1, fromPeg, spareRod);
        moveDisk(fromPeg, toPeg);
        solveHanoi(numDisks - 1, spareRod, toPeg);
    }
}

