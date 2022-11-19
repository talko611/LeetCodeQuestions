package Medium;
//Question 438

//Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//        Example 1:
//        Input: s = "cbaebabacd", p = "abc"
//        Output: [0,6]
//        Explanation:
//        The substring with start index = 0 is "cba", which is an anagram of "abc".
//        The substring with start index = 6 is "bac", which is an anagram of "abc".


import java.util.*;

public class Find_All_Anagrams_in_a_String {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.isEmpty()) return result;
        Map<Character, Integer> letterAppearances = new HashMap<>();
        //Initial map to occurrences in p for each character
        p.chars().forEach(ch ->{
            if(letterAppearances.containsKey((char) ch))
                letterAppearances.put((char) ch, letterAppearances.get((char)ch) + 1);
            else
                letterAppearances.put((char) ch, 1);
        });
        int right = 0;
        int left = 0;
        int count = p.length();
        //Moving window technique
        while(right < s.length()){
            //Case right edge of window is on letter in p
            if(letterAppearances.containsKey(s.charAt(right))){
                //If window does not contain all the occurrences of current letter
                if(letterAppearances.get(s.charAt(right)) > 0){
                    letterAppearances.merge(s.charAt(right), -1, Integer::sum);
                    ++right;
                    --count;
                }else{ //resize window form left side leaving the first letter
                    letterAppearances.merge(s.charAt(left), 1, Integer::sum);
                    ++count;
                    ++left;
                }
                if(count == 0) result.add(left);//Check if a permutation of p is found
                //decrease window size if window is reached to p size
                if(right - left == p.length() && letterAppearances.get(s.charAt(left)) >= 0){
                    letterAppearances.merge(s.charAt(left), 1, Integer::sum);
                    ++left;
                    ++count;
                }
            }else{
                //Case found a letter that is not in p resize window to 1 and to the letter after the right edge of the window
                ++right;
                while (left != right){
                    if(letterAppearances.containsKey(s.charAt(left))){
                        letterAppearances.merge(s.charAt(left), 1, Integer::sum);
                        ++count;
                    }
                    ++left;
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        Find_All_Anagrams_in_a_String solution = new Find_All_Anagrams_in_a_String();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
        int [] ints = new int[3];
        System.out.println(ints.length);
    }
}
