class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap();
            endOfWord = false;
        }
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode current = root;
        for (Character c : word.toCharArray()) {
            TrieNode node = current.children.get(c);
            if (node == null) {
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    public String getRootWord(String word) {
        if (root.children.get(word.charAt(0)) == null)
            return word;

        TrieNode current = root;
        StringBuilder sb = new StringBuilder("");
        for (Character c : word.toCharArray()) {
            TrieNode node = current.children.get(c);
            sb.append(c);
            if (node == null)
                return word;
            else if (node != null && node.endOfWord) {
                return sb.toString();
            } else {
                current = node;
            }
        }
        return word;
    }

    public String replaceWords(List<String> dict, String sentence) {
        dict.forEach(s -> insert(s));
        String[] sent = sentence.split(" ");
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < sent.length; i++) {
            sb.append(getRootWord(sent[i])).append(" ");
        }

        return sb.toString().trim();
    }
}
