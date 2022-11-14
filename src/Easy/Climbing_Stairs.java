package Easy;

//Question 70
//You are climbing a staircase. It takes n steps to reach the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//Example:
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top;
//1. 1 step + 1 step
//2. 2 steps

public class Climbing_Stairs {

    public static int climbStairsRec(int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        return climbStairsRec(n - 1) + climbStairsRec(n - 2);
    }

    public static int climbStairsItr(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        int a1 = 1;
        int a2 = 2;
        int An = -1;
        for(int i = 3; i <= n; ++i){
            An = a1 + a2;
            a1 = a2;
            a2 = An;
        }
        return An;
    }

    public static void main(String[] args) {
        System.out.println(Climbing_Stairs.climbStairsRec(7));
        System.out.println(Climbing_Stairs.climbStairsItr(7));
    }

}
