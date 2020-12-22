import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterComboPhoneNum {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        System.out.println(letterCombinations(list, map, "23"));
    }
    private static List<String> letterCombinations(List<String> list, Map<Character, String> map, String digits) {
        if(digits.length() == 0){
            return list;
        }

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        findStrings(list, map, new char[digits.length()], 0, digits);
        return list;
    }

    private static void findStrings(List<String> list, Map<Character, String> map, char[] str, int charIndex, String digits){
        if(charIndex >= digits.length()){
            list.add(new String(str));
            return;
        }
        char ch = digits.charAt(charIndex);
        for(int i = 0; i < map.get(ch).length(); i++){
            str[charIndex] = map.get(ch).charAt(i);
            findStrings(list, map, str, charIndex+1, digits);
        }
    }
}
