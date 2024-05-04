class Solution {

    int from_left = 1;
    int from_right = 2;
    int from_up = 3;
    int from_bottom = 4;

    boolean dfs(int[][] grid, int i, int j, int d) {        
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) 
            return grid[grid.length - 1][grid[0].length - 1] == 0;

        switch (grid[i][j]) {
            case 1:
                if (d == from_up || d == from_bottom) return false;
                grid[i][j] = 0;
                return dfs(grid, i, j + 1, from_left) || dfs(grid, i, j - 1, from_right);

            case 2:
                if (d == from_left || d == from_right) return false;
                grid[i][j] = 0;
                return dfs(grid, i + 1, j, from_up) || dfs(grid, i - 1, j, from_bottom);

            case 3:
                if (d == from_up || d == from_right) return false;
                grid[i][j] = 0;
                return dfs(grid, i + 1, j, from_up) || dfs(grid, i, j - 1, from_right);

            case 4:
                if (d == from_up || d == from_left) return false;
                grid[i][j] = 0;
                return dfs(grid, i, j + 1, from_left) || dfs(grid, i + 1, j, from_up);

            case 5:
                if (d == from_bottom || d == from_right) return false;
                grid[i][j] = 0;
                return dfs(grid, i - 1, j, from_bottom) || dfs(grid, i, j - 1, from_right);

            case 6:
                if (d == from_bottom || d == from_left) return false;
                grid[i][j] = 0;
                return dfs(grid, i, j + 1, from_left) || dfs(grid, i, j - 1, from_bottom);
        }

        return false;
    }


    public boolean hasValidPath(int[][] grid) {
        return dfs(grid, 0, 0, 0);
    }
}
