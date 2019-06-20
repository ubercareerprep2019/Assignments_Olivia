package Part5;

import java.util.ArrayList;

/** HanoiSolve class used to test out Hanoi logic implementation
 * within Part5 package. Running main() runs the logical moves from
 * rod at index0 to rod at index2 with a default of 3 disks.
 *
 * User can also run main() and pass in an integer > 3 to modify
 * number of disks used to run through same algorithm.
 *
 * @author olivialee
 * */

class HanoiSolve {

    //instance variables
    static Hanoi init;

    public static void main(String[] args) {
        if (args.length != 0) {
            int numDisks = Integer.parseInt(args[0]);
            init = new Hanoi(numDisks);
        } else {
            init = new Hanoi();
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(init.disksAtRod(i));
        }
        init.solveHanoi(init.numberOfDisks(),0, 2);
        for (int i = 0; i < 3; i++) {
            System.out.println(init.disksAtRod(i));
        }
    }
}
