class WordDictionary {
    class TrieNode{
        Map<Character, TrieNode> children;
        boolean isEnd;
        TrieNode(){
            children = new HashMap<>();
            isEnd = false;
        }
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TrieNode());
                
            }
            curr = curr.children.get(c);
        }
        curr.isEnd=true;
    }
    public boolean search(String word){
        return searchFromNode(word, root);
    }
    
    public boolean searchFromNode(String word, TrieNode node) {
        
        
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            
            if(!node.children.containsKey(c)){
                if(c =='.'){
                    for(char ch : node.children.keySet())
                    {
                        if(searchFromNode(word.substring(i+1), node.children.get(ch)))
                            return true;
                    }
                    
                }
                return false;
                
            }
            else
                node = node.children.get(c);
        }
        return node.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */