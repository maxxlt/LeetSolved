import java.util.ArrayList;
import java.util.List;

public class FindDiagonalOrder {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> individual_list1 = new ArrayList<>();
        individual_list1.add(1);
        individual_list1.add(2);
        individual_list1.add(3);
        list.add(individual_list1);
        List<Integer> individual_list2 = new ArrayList<>();
        individual_list2.add(4);
        individual_list2.add(5);
        individual_list2.add(6);
        list.add(individual_list2);
        List<Integer> individual_list3 = new ArrayList<>();
        individual_list3.add(7);
        individual_list3.add(8);
        individual_list3.add(9);
        list.add(individual_list3);
        for (int num : findDiagonalOrder(list)){
            System.out.print(num + " ");
        }
        System.out.println();
    }
    private static int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> map = new ArrayList<>();
        int maxIndex = 0;
        int size=0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            size+=list.size();
            for (int j = 0; j < list.size(); j++) {
                if(map.size()==i+j) map.add(new ArrayList());
                map.get(i + j).add(list.get(j));
                maxIndex = Math.max(maxIndex, i + j);
            }
        }
        int[] result = new int[size];
        int index = 0;
        for (int i = 0; i <= maxIndex; i++) {
            List<Integer> list = map.get(i);
            // Add the elemets to the result in reverse order
            for(int j=list.size()-1;j>=0;j--){
                result[index++] = list.get(j);
            }
        }
        return result;
    }
}
