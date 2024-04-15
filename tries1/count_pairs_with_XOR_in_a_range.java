class Solution {
    public int countPairs(int[] nums, int low, int high) {
        TrieNode root = new TrieNode();
        int cntPairs = 0;
        for (int num: nums) { 
            cntPairs += cntSmaller(root, num, high + 1) - cntSmaller(root, num, low); 
            insertTrie(root, num);
        }
        return cntPairs;
    }

    private int cntSmaller(TrieNode root, int N, int K) {
        int cntPairs = 0;
        for (int i = 14; i >= 0 && root != null; i--) {                  
            int x = (N >> i) & 1;
            int y = (K >> i) & 1; 
            if (y == 1) {
                if (root.child[x] != null)
                    cntPairs += root.child[x].cnt;

                root = root.child[1 - x];
            } else{
                root = root.child[x];
            }
        }
        return cntPairs;
    }

    class TrieNode {
        TrieNode child[];
        int cnt;
        public TrieNode() {
            this.child = new TrieNode[2];
            this.cnt = 0;
        }
    }

    private void insertTrie(TrieNode root, int N) {
        for (int i = 14; i >= 0; i--){
            int x = (N >> i) & 1;
            if (root.child[x] == null) {
                root.child[x] = new TrieNode();
            }
            root.child[x].cnt += 1;
            root = root.child[x];
        }
    }
}
