public class MaxSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    private static int maxSubArray(int[] nums) {
        System.out.print("nums = ");
        for(int num: nums){
            System.out.print(num + " ");
        }
        System.out.println();
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int j=1; j< nums.length; j++)
        {
            System.out.println("j = " + j);
            currentSum = Math.max(currentSum + nums[j], nums[j]);
            maxSum = Math.max(currentSum, maxSum);
            System.out.print("currentSum = " + currentSum + ", maxSum = " + maxSum + "\n");
            System.out.println();
        }
        return maxSum;
    }
}
