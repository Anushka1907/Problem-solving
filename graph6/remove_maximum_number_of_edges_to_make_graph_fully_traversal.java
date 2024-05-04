class DSU {
    int[] parent, rank;

    DSU(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        Arrays.fill(rank, 1);
        for (int i = 0; i <= n; i++)
            parent[i] = i;
    }

    int find(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = find(parent[u]);
    }

    boolean union(int u, int v) {
        int up = find(u);
        int vp = find(v);
        if (up == vp)
            return false;
        if (rank[up] < rank[vp]) {
            parent[up] = vp;
        } else {
            parent[vp] = up;
            if (rank[up] == rank[vp]) {
                rank[up]++;
            }
        }
        return true;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int red = 0, bob = 0, alice = 0;
        DSU aliceDs = new DSU(n);
        DSU bobDs = new DSU(n);
        for (int[] e : edges) {
            if (e[0] == 3) {
                if (aliceDs.union(e[1], e[2])) {
                    bobDs.union(e[1], e[2]);
                    bob++;
                    alice++;
                } else {
                    red++;
                }
            }
        }
        for (int[] e : edges) {
            if (e[0] == 1) {
                if (aliceDs.union(e[1], e[2]))
                    alice++;
                else
                    red++;
            }
            if (e[0] == 2) {
                if (bobDs.union(e[1], e[2]))
                    bob++;
                else
                    red++;
            }
        }
        if (bob == n - 1 && alice == n - 1) {
            return red;
        }
        return -1;
    }
}
