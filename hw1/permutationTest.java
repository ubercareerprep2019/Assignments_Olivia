import static org.junit.Assert.*;
import org.junit.Test;

import jdk.internal.jline.internal.TestAccessible;

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

    @Test 
    public void testLength() {
        String s1 = "hello";
        String s2 = "helloo";
        assertFalse(Permutation.isStringPermutation(s1, s2));
    }    

    @Test
    public void testForward() {
        String s1 = "hello";
        String s2 = "lohel";
        assertTrue(Permutation.isStringPermutation(s1, s2));
    }

    @Test
    public void testBackward() {
        String s1 = "hello";
        String s2 = "lohel";
        assertTrue(Permutation.isStringPermutation(s1, s2));
    }
}
