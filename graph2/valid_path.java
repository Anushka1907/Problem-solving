
class Solution {
    int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};

    boolean isValid(int x, int y, int n, int m){
        return x >= 0 && y >= 0 && x <= n && y <= m;
    }

    public String solve(int a, int b, int n, int r, ArrayList<Integer> A, ArrayList<Integer> B) {
        int[][] vis = new int[a+2][b+2];
        int[][] d = new int[a+2][b+2];
        
        for(int i = 0; i <= a; ++i){
            for(int j = 0; j <= b; ++j){
                for(int k = 0; k < n; ++k){
                    if((i - A.get(k)) * (i - A.get(k)) + (j - B.get(k)) * (j - B.get(k)) <= r * r){
                        vis[i][j] = 1;
                    }
                }
            }
        }
        
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(0, 0));
        vis[0][0] = 1;

        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            int x = p.getKey();
            int y = p.getValue();
            if(x == a && y == b) return "YES";
            for(int i = 0; i < 8; ++i){
                int X = x + dx[i], Y = y + dy[i];
                if(isValid(X, Y, a, b) && vis[X][Y] == 0){
                    q.add(new Pair<>(X, Y));
                    vis[X][Y] = 1;
                }
            }
        }

        return "NO";
    }
}
