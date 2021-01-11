public class NumIslands {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
    }
    private static int numIslands(char[][] grid) {
        if (grid.length == 0){
            return 0;
        }
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                numIslands += dfs(grid, i, j);
            }
        }
        return numIslands;
    }
    private static int dfs(char[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0'){
            return 0;
        }
        grid[i][j] = '0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        return 1;
    }
}
