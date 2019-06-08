package Part2;

import javafx.util.Pair;
import java.util.ArrayList;

class EqualSum {
    static ArrayList<Pair<Integer, Integer>> pairsThatEqualSum(ArrayList<Integer> inputArray, int targetSum) {
        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList();

        for (int i = 0; i < inputArray.size(); i++) {
            int first = inputArray.get(i);
            if (first > targetSum) {
                continue;
            }
            if (inputArray.contains(targetSum - first)) {
                Pair<Integer, Integer> toAdd = new Pair(first, targetSum - first);
                pairs.add(toAdd);
            }
        }
        return pairs;
    }
}
