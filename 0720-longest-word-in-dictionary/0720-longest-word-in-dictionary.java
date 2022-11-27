class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];

        }
    }

    TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }
    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String w: words){
            insert(w);
        }
        Queue<TrieNode> q = new LinkedList<>();
        q.add(root);
        TrieNode curr = root;
        
        while(!q.isEmpty()){
            curr = q.poll();
            for(int i = 25; i>=0; i--){
                if(curr.children[i] != null && curr.children[i].word != null){
                    q.add(curr.children[i]);
                }
                
            }
        }
        if(curr.word == null){
            return  "";
        }
        return curr.word;
    }
}