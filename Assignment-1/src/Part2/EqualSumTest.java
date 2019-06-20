package Part2;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import javafx.util.Pair;

/** EqualSumTest class used as both unit and integration test
 *  for homework part2 package on array manipulation
 *
 * @author olivialee
 * **/

public class EqualSumTest {

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