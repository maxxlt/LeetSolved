package dp;

public class PerfectSquares {
    public static void main(String[] args) {
        numSquares(13);
    }
    private static int numSquares(int n) {
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i =1; i <=n;i++){
            System.out.println("Original");
            for (int z = 1; z <= n; z++){
                System.out.print(z + " ");
            }
            System.out.println();
            System.out.println("Number of Perfect Squares");
            //      13
            //      v
            dp[i] = i;
            for(int j =1; j*j<=i;j++){
                dp[i] = Math.min(dp[i], 1+dp[i -j*j]);

                for (int y = 1; y < dp.length; y++){
                    System.out.print(dp[y] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        return dp[n];
    }
}
