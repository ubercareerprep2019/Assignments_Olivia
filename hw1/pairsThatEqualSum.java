import static org.junit.Assert.*;
import java.util.Array;
import java.util.ArrayList;
import javafx.util.Pair; 

/* Function takes an array of integers and a target integer to which the array 
 * elements must sum; returns an array of all pairs of integers from the input 
 * array whose sum equals the target.
 *  
 * @author Olivia Lee
 */


public class EqualSum {
    public static Array<Pair<Integer>> pairsThatEqualSum(Array<Integer> inputArray, int targetSum) {
        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList();

        for (int i = 0; i < inputArray.size(); i++) {
            int first = get(inputArray, i);
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

    public static void main(String[] args) {
        println("check compilation");
    }
}