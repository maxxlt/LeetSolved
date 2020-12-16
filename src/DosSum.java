import java.util.HashMap;
import java.util.Map;

public class DosSum {
    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //
    //You can return the answer in any order.
    //Example 1:
    //
    //Input: nums = [2,7,11,15], target = 9
    //Output: [0,1]
    //Output: Because nums[0] + nums[1] == 9, we return [0, 1].
    //Example 2:
    //
    //Input: nums = [3,2,4], target = 6
    //Output: [1,2]
    //Example 3:
    //
    //Input: nums = [3,3], target = 6
    //Output: [0,1]
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums,target);
        if (result == null){
            System.out.println("[]");
        }
        else {
            for (int num : result){
                System.out.println(num);
            }
        }
    }
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> savedNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            //if the difference is one of the past saved numbers, return indexes
            if (savedNums.containsKey(diff)) {
                return new int[]{ savedNums.get(diff), i };
            }
            //otherwise we saving number in the hashmap
            savedNums.put(nums[i], i);
        }
        return null;
    }
}
