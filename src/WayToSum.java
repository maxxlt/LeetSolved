import java.util.ArrayList;
import java.util.List;

public class WayToSum {
    public static void main(String[] args) {
        List<List<Integer>> combo = combinationSum(new int[]{1,2,3},5);
        for (List<Integer> list: combo){
            System.out.println(list.toString());
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {


        List<List<Integer>> res = new ArrayList<>();

        List<Integer> subSet = new ArrayList<>();

        if(candidates == null || candidates.length == 0) return res;

        dfs(candidates, res, subSet, target, 0);
        return res;
    }
    private static void dfs(int[]candidates, List<List<Integer>> res, List<Integer> subset, int target, int index){

        //hit jackpot, we summed it right
        if(target == 0){
            res.add(new ArrayList<>(subset));
            return;
        }
        if(target < 0){//subset sum greater than target, missed the target, moving on;
            return;
        }

        for(int i = index; i < candidates.length; i++){
            subset.add(candidates[i]);
            dfs(candidates, res, subset, target - candidates[i], i);
            subset.remove(subset.size()-1); //backtracking.
        }
    }
}
