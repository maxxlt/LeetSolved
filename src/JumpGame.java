public class JumpGame {
    /*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 3 * 10^4
0 <= nums[i][j] <= 10^5
     */
    public static void main(String[] args) {

    }
    private static boolean canJump(int[] nums){
        return canJumpHelper(0, nums);
    }

    private static boolean canJumpHelper(int position, int[] nums) {
        //position reached the final destination, good, return true;
        if (position == nums.length-1) return true;
        //furthestJump will pick the min to avoid out of bound runtime error in case if final destination is near but position can go further
        int furthestJump = Math.min(position + nums[position], nums.length-1);
        for (int nextPosition = position+1; nextPosition <= furthestJump; nextPosition++){
            //recurse until we tried all possible ways to reach final destination
            if (canJumpHelper(nextPosition, nums)){
                return true;
            }
        }
        //couldn't reach final destination, returning false
        return false;
    }

}
