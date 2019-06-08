package Part2;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class PermutationTest {

    @Test
    void testSanity() {
        String sanity = "hello";
        assertTrue(Permutation.isStringPermutation(sanity, sanity));
    }

    @Test
    void testSimple() {
        String s1 = "hello";
        String s2 = "elloh";
        assertTrue(Permutation.isStringPermutation(s1, s2));
    }

    @Test
    void testEmpty() {
        String s1 = "hello";
        String s2 = "";
        assertFalse(Permutation.isStringPermutation(s1, s2));
    }

    @Test
    void testLength() {
        String s1 = "hello";
        String s2 = "helloo";
        assertFalse(Permutation.isStringPermutation(s1, s2));
    }

    @Test
    void testForward() {
        String s1 = "hello";
        String s2 = "lohel";
        assertTrue(Permutation.isStringPermutation(s1, s2));
    }

    @Test
    void testBackward() {
        String s1 = "hello";
        String s2 = "lohel";
        assertTrue(Permutation.isStringPermutation(s1, s2));
    }
}