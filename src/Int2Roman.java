import java.util.Scanner;

public class Int2Roman {
    //Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    //
    //Symbol       Value
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    //For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
    //
    //Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
    //
    //I can be placed before V (5) and X (10) to make 4 and 9.
    //X can be placed before L (50) and C (100) to make 40 and 90.
    //C can be placed before D (500) and M (1000) to make 400 and 900.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = input.nextInt();
        System.out.println(intToRoman(num));
    }
    private static String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        while(num>0) {
            if(num>=1000) {
                roman.append("M");
                num=num-1000;
            } else if(num>=900) {
                roman.append("CM");
                num = num-900;
            } else if(num>=500) {
                roman.append("D");
                num = num-500;
            } else if(num>=400) {
                roman.append("CD");
                num = num-400;
            } else if(num>=100){
                roman.append("C");
                num=num-100;
            } else if(num>=90) {
                roman.append("XC");
                num =num -90;
            } else if(num>=50) {
                roman.append("L");
                num = num-50;
            } else if(num>=40) {
                roman.append("XL");
                num = num-40;
            } else if(num>=10) {
                roman.append("X");
                num = num-10;
            } else if(num==9) {
                roman.append("IX");
                num =num-9;
            } else if(num>=5) {
                roman.append("V");
                num = num-5;
            } else if(num==4) {
                roman.append("IV");
                num =num-4;
            } else {
                roman.append("I");
                num = num-1;
            }
        }
        return roman.toString();
    }
}
