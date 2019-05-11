/* Function takes two strings and returns true if
 * one string is a permutation of the other, false otherwise
 *
 * @author Olivia Lee
 */

public class Permutation {

    public static boolean isStringPermutation(String s1, String s2) {
        //base case:
        if (s1.length() != s2.length()) {
            return false;
        }
        boolean forward = true; //initial check for forward permutation
        char front = s1.charAt(0);
        int s2Index = s2.indexOf(front); //searching for first character of s1 in s2

        if (start == -1) {
            return false;
        }

        //forward case
        while (s2Index != -1) {
            String sub = s2.substring(s2Index);
            String corrS1 = s1.substring(0, sub.length()); //corresponding substring in s1
            if (sub.equals(corrS1)) {
                if (s2.substring(0, s2.length() - sub.length())) {
                    return true;
                }
                s2Index = s2.substring(1).indexOf(front);
            }
        }

        //backward case: need to check one char at a time
        int s1Index = 0;
        int count = 1, complete = 0;
        s2Index = s2.indexOf(front);
        while (s2Index != -1) {
            if (complete == s1.length()) {
                return true;
            }
            if (s1.charAt(s1index) != s2.charAt(s2Index)) {
                s2Index = s2.substring(count).indexOf(front);
                count++;
                complete = 0;
                continue;
            }
            s1Index = (s1Index - 1) % s1.length();
            s2Index = (s2Index - 1) % s2.length();
            complete++;
        }
        return false;
    }


    public static void main(String[] args) {
        Permutation test = new Permutation();
    }

}