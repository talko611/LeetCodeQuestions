package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Two_Sum solution = new Two_Sum();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{2,4,9,10,5}, 12)));
    }
}
