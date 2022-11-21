package Easy;
//Question 14

//Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".
//        Example 1:
//        Input: strs = ["flower","flow","flight"]
//        Output: "fl"

import java.util.Arrays;

public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        String maxCommonStr = strs[0];
        String curStr;
        for(int i = 1; i < strs.length && !maxCommonStr.isEmpty(); ++i){
            curStr = strs[i];
            if(maxCommonStr.length() > curStr.length()) maxCommonStr = maxCommonStr.substring(0,curStr.length());
            for(int j = 0; j < maxCommonStr.length(); ++j){
                if(curStr.charAt(j) != maxCommonStr.charAt(j))
                    maxCommonStr = maxCommonStr.substring(0,j);
            }
        }
        return maxCommonStr;
    }

    public static void main(String[] args) {
        Longest_Common_Prefix solution = new Longest_Common_Prefix();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
