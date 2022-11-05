package Medium;

import java.util.HashMap;
import java.util.Map;



//Given a string s, find the length of the longest substring without repeating characters.
//        Example 1:
//
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.

public class LongestSubStringProblem {
    private final Map<String, Integer> charToAppearance;

    public LongestSubStringProblem(){
        this.charToAppearance = new HashMap<>();
    }
    public int lengthOfLongestSubstring(String s){
        if(!s.isEmpty()){
            int counter = 1;
            int maxCounter  = 1;
            int subStringStartingPoint = 0;
            charToAppearance.put(String.valueOf(s.charAt(0)), 0);
            for(int i = 1; i < s.length(); ++i){
                String currentCh = String.valueOf(s.charAt(i));
                if(charToAppearance.containsKey(currentCh) && charToAppearance.get(currentCh) >= subStringStartingPoint){
                    maxCounter = Math.max(maxCounter, counter);
                    counter = i - charToAppearance.get(currentCh);
                    subStringStartingPoint = i - counter;
                }else {
                    ++counter;
                }
                charToAppearance.put(currentCh, i);
            }
            return Math.max(maxCounter,counter);
        }
        return 0;
    }

    public static void main(String[] args) {
        LongestSubStringProblem longestSubStringProblem = new LongestSubStringProblem();
        System.out.println(longestSubStringProblem.lengthOfLongestSubstring("au"));
    }
}
