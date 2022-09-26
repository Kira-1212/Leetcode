class StreamChecker {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
            
        }
    }
    TrieNode root;
    
    private void insert(String s){
        TrieNode curr = root;
        for( int i = s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    StringBuilder sb;
    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for(String word : words){
            insert(word);
        }
    }
    
    public boolean query(char letter) {
        TrieNode curr = root;
        sb.append(letter);
        for(int i = sb.length()-1; i>=0; i--){
            char c = sb.charAt(i);
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
            
            if(curr.isEnd)
                return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */