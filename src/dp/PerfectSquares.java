package dp;

public class PerfectSquares {
    public static void main(String[] args) {
        numSquares(12);
    }
    private static int numSquares(int n) {
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i =1; i <=n;i++){
            dp[i] = i;
            for(int j =1; j*j<=i;j++){
                dp[i] = Math.min(dp[i], 1+dp[i -j*j]);
            }
        }
        System.out.println("Perfect Squares");
        for (int num : dp){
            System.out.print(num + " ");
        }
        return dp[n];
    }
}
