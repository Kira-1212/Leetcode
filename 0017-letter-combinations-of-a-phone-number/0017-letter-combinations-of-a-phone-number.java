class Solution {
    List<String> result;
    HashMap<Character, char[]> map;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        map = new HashMap<>();
        
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        if(digits == null || digits.length() == 0)
            return result;
        backtrack(digits, 0, new StringBuilder());
        
        return result;
    }
    private void backtrack(String digits, int i, StringBuilder sb){
        
        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }
        char[] possible = map.get(digits.charAt(i));
        for(char c : possible){
            sb.append(c);
            backtrack(digits , i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}