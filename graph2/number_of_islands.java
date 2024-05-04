class Solution {
    int m;
    int n;
    private List<int[]> dir = new ArrayList<>();
    
    void dfs(char[][] grid,int row,int col){
        int rows= grid.length,
        cols= grid[0].length;
         if(row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] != '1')
                return;
            grid[row][col] = '0';
            dfs(grid,row - 1, col);
            dfs(grid,row + 1, col);
            dfs(grid,row, col - 1);
            dfs(grid,row, col + 1);
    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        if(m==0) return 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
