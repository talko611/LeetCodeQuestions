package Easy;

//Question 746
//You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
//You can either start from the step with index 0, or the step with index 1.
//Return the minimum cost to reach the top of the floor.
//        Example 1:
//        Input: cost = [10,15,20]
//        Output: 15
//        Explanation: You will start at index 1.
//        - Pay 15 and climb two steps to reach the top.
//        The total cost is 15.

//[1,100,1,1,1,100,1,1,100,1]

import java.util.Arrays;

public class Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost) {
        int min1 = cost[0];
        int min2 = cost[1];
        int min3;
        for(int i = 2; i <= cost.length; ++i){
            if(i == cost.length)
                min3 = Math.min(min1, min2);
            else
                min3 = Math.min(min1 + cost[i], min2 + cost[i]);
            min1 = min2;
            min2 = min3;
        }
        return Math.min(min1, min2);
    }

    public static void main(String[] args) {
        Min_Cost_Climbing_Stairs solution = new Min_Cost_Climbing_Stairs();
        System.out.println(solution.minCostClimbingStairs(new int[]{0,1,2,2}));
    }
}
