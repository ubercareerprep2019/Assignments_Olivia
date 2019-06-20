package Part2;

import javafx.util.Pair;
import java.util.ArrayList;

/** EqualSum class implements pairsThatEqualSum function, which
 *  takes an array of integers and a target integer to which the array
 *  elements must sum. It returns an array of all pairs of integers
 *  from the input array whose sum equals the target.
 *
 * @author olivialee
 * */

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
