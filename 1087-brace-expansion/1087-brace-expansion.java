class Solution {
    List<List<Character>> blocks;
    List<String> result;
    public String[] expand(String s) {
        if(s == null ||s.length() == 0)return new String[]{};
        blocks = new ArrayList<>();
        result = new ArrayList<>();
        int i =0;
        while(i<s.length()){
            List<Character> block = new ArrayList<>(); 
            if( s.charAt(i) == '{'){
                i++;
                while(s.charAt(i) !='}'){
                    if(s.charAt(i)!= ',')
                        block.add(s.charAt(i));
                    i++;
                }
                
            }
            else
                block.add(s.charAt(i));
            i++;
            blocks.add(block);
        }
        backtrack(0, new StringBuilder());
        
        String[] answer = new String[result.size()];
        for(int j = 0; j<result.size(); j++)
            answer[j] = result.get(j);
        Arrays.sort(answer);
        return answer;
    }
    
    private void backtrack(int index, StringBuilder sb){
        if(index == blocks.size()){
            result.add(sb.toString());
            return;
        }
        List<Character> block = blocks.get(index);
        for(int i = 0; i<block.size(); i++){
            sb.append(block.get(i));
            backtrack(index +1, sb);
            sb.setLength(sb.length()-1);
        }
    }
}