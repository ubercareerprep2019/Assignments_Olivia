import static org.junit.Assert.*;
import org.junit.Test;

public class permutationTest {

    /** Performs a few arbitrary tests to check if isStringPermutation method is correct */

    @Test
    public void testSimple() {
        String s1 = "hello";
        String s2 = "elloh";
        assertTrue(Permutation.isStringPermutation(s1, s2));
    }

    @Test
    public void testEmpty() {
        String s1 = "hello";
        String s2 = "";
        assertFalse(Permutation.isStringPermutation(s1, s2));
    }

    public static void main(String[] args) {

    }

}
