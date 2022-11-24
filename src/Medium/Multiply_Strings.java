package Medium;

//Question 43
//Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
//        Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
//        Example 1:
//        Input: num1 = "2", num2 = "3"
//        Output: "6"

import java.util.ArrayList;
import java.util.List;

public class Multiply_Strings {
    public String multiply(String num1, String num2) {
        int digit1;
        int digit2;
        int product;
        int curry;
        int startFrom;
        List<Integer> result = new ArrayList<>();
        for(int i = num1.length() -1; i >= 0; --i){
            digit1 = num1.charAt(i) - '0';
            curry = 0;
            startFrom = num1.length() -1 - i;
            for(int j = num2.length() - 1; j >= 0; --j){
                digit2 = num2.charAt(j) -'0';
                if(startFrom > result.size() -1){
                    product = (digit1 * digit2) + curry;
                    result.add(product % 10);
                }else{
                    product = (digit1 * digit2) + curry + result.get(startFrom);
                    result.set(startFrom, product % 10);
                }
                curry = product / 10;
                ++startFrom;
            }
            if(curry != 0) result.add(curry);
        }
        StringBuilder builder = new StringBuilder();
        for(int digit : result) builder.append(digit);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Multiply_Strings solution = new Multiply_Strings();
        System.out.println(solution.multiply("340", "384822"));
    }
}
