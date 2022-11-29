class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(String s, int index, List<String> path){
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = index; i<s.length(); i++){
            String part = s.substring(index, i+1);
            if(isPalindrome(part)){
                path.add(part);
                backtrack(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
        
        
    }
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}