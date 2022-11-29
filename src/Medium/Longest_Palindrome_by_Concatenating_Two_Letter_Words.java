package Medium;
//Question 2131
//You are given an array of strings words. Each element of words consists of two lowercase English letters.
//Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
//Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
//A palindrome is a string that reads the same forward and backward.
//Example 1:
//Input: words = ["lc","cl","gg"]
//Output: 6
//Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
//Note that "clgglc" is another longest palindrome that can be created.

import Easy.Longest_Palindrome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Longest_Palindrome_by_Concatenating_Two_Letter_Words {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> differentLetters = new HashMap<>();
        StringBuilder builder;
        int differentCouplesCounter = 0;
        int sameLetterCouples = 0;
        int val;
        for (String word : words) {
            val = differentLetters.merge(word,1, Integer::sum);
            if(word.charAt(0) == word.charAt(1)){
                if(val % 2 == 0){
                    --sameLetterCouples;
                    ++differentCouplesCounter;
                }
                else{
                    ++sameLetterCouples;
                }
            }
            else {
                builder = new StringBuilder(word).reverse();
                if(differentLetters.containsKey(builder.toString()) && differentLetters.get(builder.toString()) >= val){
                    ++differentCouplesCounter;
                }
            }
        }
        return (differentCouplesCounter * 4) + (sameLetterCouples != 0 ? 2 : 0);
    }

    public static void main(String[] args) {
        String[] words = new String[]{"em","pe","mp","ee","pp","me","ep","em","em","me"};
        Longest_Palindrome_by_Concatenating_Two_Letter_Words solution  = new Longest_Palindrome_by_Concatenating_Two_Letter_Words();
        System.out.println(solution.longestPalindrome(words));
    }
}
