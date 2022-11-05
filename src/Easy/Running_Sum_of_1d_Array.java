package Easy;

//Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//        Return the running sum of nums.
//Example 1:
//        Input: nums = [1,2,3,4]
//        Output: [1,3,6,10]
//        Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
public class Running_Sum_of_1d_Array {
    public int[] runningSum(int[] nums){
        if(nums.length != 0){
            int[] runningSum = new int[nums.length];
            runningSum[0] = nums[0];
            for(int i = 1; i < nums.length; ++i){
                runningSum[i] = runningSum[i -1] + nums[i];
            }
            return runningSum;
        }
        return new int[]{0};
    }
}
