package Part5;

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
        init.solveHanoi(init.numberOfDisks(),0, 2);
        for (int i = 0; i < 3; i++) {
            System.out.println(init.disksAtRod(i));
        }
    }
}
