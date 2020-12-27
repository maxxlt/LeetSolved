import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
    }
    private static int majorityElement(int[] nums) {
        int target = nums.length/2;
        int res = 0;
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums){
            numMap.put(num, numMap.getOrDefault(num, 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()){
            if (entry.getValue() > target){
                res = entry.getKey();
            }
        }
        return res;
    }
}
