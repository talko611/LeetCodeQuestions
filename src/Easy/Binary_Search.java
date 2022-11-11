package Easy;


//Question 704
//Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
//You must write an algorithm with O(log n) runtime complexity.

public class Binary_Search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int middle;
        while (left <= right){
            middle = (right - left) / 2 + left;
            if(nums[middle] == target)
                return middle;
            else if (nums[middle] < target) {
                left = middle + 1;
            }
            else {
                right = middle -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Binary_Search binarySearch = new Binary_Search();
        System.out.println(binarySearch.search(new int[]{-1,0,3,5,9,12}, 9));
    }
}
