public class PrintPermutation {
    public static void main(String[] args) {
        String str = "Max";
        printPermutation(str, "");
    }
    static void printPermutation(String str, String ans)
    {
        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            //return to original function call
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // pulling out a character
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String modified_str = str.substring(0, i) +
                    str.substring(i + 1);

            printPermutation(modified_str, ans + ch);
        }
    }
}
