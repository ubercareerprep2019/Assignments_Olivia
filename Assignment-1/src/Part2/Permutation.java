package Part2;

class Permutation {
    static boolean isStringPermutation(String s1, String s2) {
        //base case:
        if (s1.length() != s2.length()) {
            return false;
        }

        char front = s1.charAt(0);
        int s2Index = s2.indexOf(front); //searching for first character of s1 in s2

        if (front == -1) {
            return false;
        }

        while (s2Index != -1) {
            String sub = s2.substring(s2Index);
            String corrS1 = s1.substring(0, sub.length()); //corresponding substring in s1
            if (sub.equals(corrS1)) {
                String s2Remainder = s2.substring(0, s2.length() - sub.length());
                String s1Remainder = s1.substring(sub.length());
                if (s2Remainder.equals(s1Remainder)) {
                    return true;
                }
                s2Index = s2.substring(1).indexOf(front);
            }
        }
        return false;
    }
}
