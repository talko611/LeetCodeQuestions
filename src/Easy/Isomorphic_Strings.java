package Easy;

//Given two strings s and t, determine if they are isomorphic.
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//        Example 1:
//        Input: s = "egg", t = "add"
//        Output: true


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();
        for(int i = 0; i < s.length(); ++i){
            if(!sToT.containsKey(s.charAt(i)) && !tToS.containsKey(t.charAt(i))){
                sToT.put(s.charAt(i), t.charAt(i));
                tToS.put(t.charAt(i), s.charAt(i));
            } else if (sToT.containsKey(s.charAt(i)) && !sToT.get(s.charAt(i)).equals(t.charAt(i))) {
                return false;
            } else if (!sToT.containsKey(s.charAt(i)) && tToS.containsKey(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Isomorphic_Strings isomorphic_strings = new Isomorphic_Strings();
        System.out.println(isomorphic_strings.isIsomorphic("badc", "baba"));
    }
}
