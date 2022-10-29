class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generate(n, new StringBuilder(), 0, 0);
        return result;
    }
    
    private void generate(int n, StringBuilder sb, int open, int close){
        if(sb.length() == 2*n){
            result.add(sb.toString());
            return;
        }
        

        if(open<n){
            sb.append("(");
            generate(n, sb, open + 1, close);
            sb.deleteCharAt(sb.length()-1);
        }
         if(close<open){
            sb.append(")");
            generate(n, sb, open, close +1);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
}