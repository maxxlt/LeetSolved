import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TresSum {
    /*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []


Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
     */
    public static void main(String[] args) {
        List<List<Integer>> threesum = threeSum(new int[]{-1,0,1,2,-1,-4});
        for (List<Integer> subset : threesum){
            System.out.println(subset.toString());
        }
    }
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //corner case if input less than 3 or null
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        // |-4| |-1| |-1| |0| |1| |2|
        //  ^    ^                 ^
        // curr low              high
        for (int i = 0; i < nums.length; i++){
            //if nums[i] aka cur is greater than 0, there is no way the sum would be 0
            if (nums[i]> 0) break;
            //if the entry is duplicate, we moving on
            if (i != 0 && nums[i] == nums[i-1]) continue;
            int cur = nums[i];
            int low = i+1, high = nums.length-1;
            while(low < high){
                int sum = nums[low] + cur + nums[high];
                if (sum == 0){
                    res.add(Arrays.asList(cur, nums[low], nums[high]));
                    low++;
                    while (low < high && nums[low] == nums[low-1]){
                        low++;
                    }
                    high--;
                    while(low < high && nums[high] == nums[high+1]){
                        high--;
                    }
                } else if (sum < 0){
                    low++;
                } else {
                    high--;
                }
            }
        }

        return res;
    }
}
