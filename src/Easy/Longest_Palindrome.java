package Easy;

//Question 409

//Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
//Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

//        Example 1:
//        Input: s = "abccccdd"
//        Output: 7
//        Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

public class Longest_Palindrome {
    public int longestPalindrome(String s) {
        if(s.length() < 2) return s.length();
        int[] appearances = new int[128];
        int numOfPairs = 0;
        char current;
        for(int i = 0; i < s.length(); ++i){
            current = s.charAt(i);
            appearances[current] += 1;
            if(appearances[current] % 2 == 0){
                ++numOfPairs;
                appearances[current] = 0;
            }
        }
        if(numOfPairs * 2 < s.length())
            return numOfPairs * 2 + 1;
        else
            return numOfPairs * 2;
    }

    public static void main(String[] args) {
        Longest_Palindrome solution = new Longest_Palindrome();
        System.out.println(solution.longestPalindrome("aa"));
    }
}
