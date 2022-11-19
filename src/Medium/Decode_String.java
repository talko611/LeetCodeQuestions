package Medium;

//Question 394
//Given an encoded string, return its decoded string.
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
//The test cases are generated so that the length of the output will never exceed 105.
//Input: s = "3[a]2[bc]"
//        Output: "aaabcbc"


import java.util.Stack;

public class Decode_String {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> numbers = new Stack<>();
        Stack<String> currenStats = new Stack<>();
        int index = 0;
        char currenCh;
        while(index < s.length()){
            currenCh = s.charAt(index);
            if(Character.isDigit(currenCh)){
                int num = 0;
                while(Character.isDigit(currenCh)){
                    num = 10 * num + (currenCh - '0');
                    ++index;
                    currenCh = s.charAt(index);
                }
                numbers.push(num);
            } else if (currenCh == '[') {
                currenStats.push(res.toString());
                res = new StringBuilder();
                ++index;
            } else if (currenCh == ']') {
                res = new StringBuilder(currenStats.pop() + res.toString().repeat(numbers.pop()));
                ++index;
            }else{
                res.append(s.charAt(index++));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Decode_String solution = new Decode_String();
        new StringBuilder("letcode".repeat(100));
        System.out.println(solution.decodeString("100[leetcode]").length() / 8);
    }
}
