package Medium;

//question 299
//You are playing the Bulls and Cows game with your friend.
//You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:
//The number of "bulls", which are digits in the guess that are in the correct position.
//The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
//Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.
//The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.
//Example 1:
//        Input: secret = "1807", guess = "7810"
//        Output: "1A3B"
//        Explanation: Bulls are connected with a '|' and cows are underlined:
//        "1807"
//        |
//        "7810"


import java.util.HashMap;
import java.util.Map;

public class Bulls_and_Cows {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> remainingLettersOnSecret  = new HashMap<>();
        Map<Character, Integer> remainingLetterOnGuess = new HashMap<>();
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i < secret.length(); ++i){
            if(secret.charAt(i) == guess.charAt(i)){
                ++bulls;
            }else{
                remainingLetterOnGuess.merge(guess.charAt(i), 1, Integer::sum);
                remainingLettersOnSecret.merge(secret.charAt(i), 1, Integer::sum);
            }
        }
        for(char key : remainingLetterOnGuess.keySet()){
            if(remainingLettersOnSecret.containsKey(key)){
                cows += Math.min(remainingLettersOnSecret.get(key), remainingLetterOnGuess.get(key));
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        Bulls_and_Cows solution = new Bulls_and_Cows();
        System.out.println(solution.getHint("1122", "1222"));
    }
}
