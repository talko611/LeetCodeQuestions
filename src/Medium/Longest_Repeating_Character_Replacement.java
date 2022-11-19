package Medium;
//Question 424
//You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//        Return the length of the longest substring containing the same letter you can get after performing the above operations.
//        Example 1:
//        Input: s = "ABAB", k = 2
//        Output: 4
//        Explanation: Replace the two 'A's with two 'B's or vice versa.

public class Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int[] frequencyMap = new int[26];
        int maxFrequency = 0;
        int longestSubstringLength = 0;
        int currentCh;
        for (int end = 0; end < s.length(); end += 1) {
            currentCh = s.charAt(end) - 'A';
            frequencyMap[currentCh] += 1;
            maxFrequency = Math.max(maxFrequency, frequencyMap[currentCh]);
            if (!(end + 1 - start - maxFrequency <= k)) {
                frequencyMap[s.charAt(start) - 'A'] -= 1;
                start += 1;
            }
            longestSubstringLength = end + 1 - start;
            }
        return longestSubstringLength;
        }

    public static void main(String[] args) {
        Longest_Repeating_Character_Replacement solution = new Longest_Repeating_Character_Replacement();
        System.out.println(solution.characterReplacement("ABAB", 2));
    }
}
