class Solution {
    public boolean isCyclic(int N, List<Integer>[] adj) {
        Queue<Integer> que = new LinkedList<>();
        int[] indegree = new int[N];
        int count = 0;
        for (int u = 0; u < N; u++) {
            for (int v : adj[u]) {
                indegree[v]++;
            }
        }
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                que.add(i);
                count++;
            }
        }
        while (!que.isEmpty()) {
            int u = que.poll();

            for (int v : adj[u]) {
                indegree[v]--;

                if (indegree[v] == 0) {
                    que.add(v);
                    count++;
                }
            }
        }
        return count != N;
    }
}

