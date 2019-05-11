import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import javafx.util.Pair; 
import jdk.internal.jline.internal.TestAccessible;

//ublic static Array<Pair<Integer>> pairsThatEqualSum(Array<Integer> inputArray, int targetSum) {

public class permutationTest {

    /** Performs a few arbitrary tests to check if isStringPermutation method is correct */

    @Test 
    public void testSimple() {
        ArrayList<Integer> sample = new ArrayList();
        for (int i = 0; i < 10; i++) {
            sample.add(i);
        }

        ArrayList<Pair<Integer, Integer>> returnList = new ArrayList<>();
        returnList = EqualSum.pairsThatEqualSum(sample, 5);
        //should return list of pairs (0,5) (1,4) (2,3) (3,2) (4,1) (5,0)

        assertEquals(6, returnList.size());
    }
}
