package dp;

/*
Given a m * n matrix mat and an integer K, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K, and (r, c) is a valid position in the matrix.


Example 1:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
Output: [[12,21,16],[27,45,33],[24,39,28]]
Example 2:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
Output: [[45,45,45],[45,45,45],[45,45,45]]


Constraints:

m == mat.length
n == mat[i].length
1 <= m, n, K <= 100
1 <= mat[i][j] <= 100
 */

public class MatrixBlockSum {
    public static void main(String[] args) {
        int [][] mat = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
        System.out.println("Original");
        for (int k = 0; k < 4; k++){
            for (int m = 0; m < 4; m++){
                System.out.print(mat[k][m] + " ");
            }
            System.out.println();
        }
        int[][] blockSum = matrixBlockSum(mat, 1);
    }
    private static int[][] matrixBlockSum(int[][] mat, int K) {

        int M = mat.length;
        int N = mat[0].length;

        //dp is a prefix sum 2D array (stores the sum of previous indexes
        int[][] dp = new int[M+1][N+1];
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                dp[i+1][j+1] = mat[i][j] + dp[i][j+1] + dp[i+1][j] - dp[i][j];
            }
        }
        System.out.println("Prefix Sum");
        for (int k = 0; k < M; k++){
            for (int m = 0; m < N; m++){
                System.out.print(dp[k][m] + " ");
            }
            System.out.println();
        }

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                //We are setting min and max to avoid index to go out of bound
                int r1 = Math.max(0, i-K);
                int c1 = Math.max(0, j-K);
                int r2 = Math.min(M-1, i+K);
                int c2 = Math.min(N-1, j+K);

                mat[i][j] = dp[r2+1][c2+1] -dp[r1][c2+1] - dp[r2+1][c1] + dp[r1][c1];
            }
        }
        System.out.println("Matrix Block Sum");
        for (int[] ints : mat) {
            for (int y = 0; y < N; y++) {
                System.out.print(ints[y] + " ");
            }
            System.out.println();
        }
        return mat;
    }
}
