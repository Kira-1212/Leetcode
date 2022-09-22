class Solution {
    
    class TrieNode{
        TrieNode[] children;
        List<String> starts;
        public TrieNode(){
            children = new TrieNode[26];
            starts = new ArrayList<>();
        }
    }
    TrieNode root;
    
    private void insert(String s){
        TrieNode curr = root;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
            curr.starts.add(s);
        }
    }
    private List<String> startsWith(String pre){
        TrieNode curr = root;
        for(int i = 0; i<pre.length(); i++){
            char c = pre.charAt(i);
            if(curr.children[c-'a'] == null){
                return new ArrayList<>();
            }
            curr = curr.children[c-'a'];
            
        }
        return curr.starts;
    }
    List<List<String>> result;
    public List<List<String>> wordSquares(String[] words) {
        if(words == null || words.length == 0)return new ArrayList<>();
        result = new ArrayList<>();
        root = new TrieNode();
        for(String word : words){
            insert(word);
        }
        List<String> li = new ArrayList<>();
        for(String word: words){
            li.add(word);
            backtrack(li, word.length());
            li.remove(li.size()-1);
        }
        return result;
    }
    private void backtrack(List<String> li, int k){
        
        if(li.size() == k){
            result.add(new ArrayList<>(li));
            return;
        }
        int i = li.size();
        StringBuilder sb = new StringBuilder();
        for(String  word : li){
            sb.append(word.charAt(i));
        }
        List<String> preList = startsWith(sb.toString());
        for(String word : preList){
            li.add(word);
            backtrack(li, k);
            li.remove(li.size() -1);
        }
    }
}