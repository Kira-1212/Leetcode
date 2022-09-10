class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        HashMap<String,List<String>> map = new HashMap<>();
        List<String> temp;
        String modified;
        for(String word: wordList){
            for(int i=0; i<word.length();i++){
                modified = i+word.substring(0,i)+word.substring(i+1,word.length());
                temp = map.getOrDefault(modified, new ArrayList<String>());
                temp.add(word);
                map.put(modified, temp);
            }
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int size;
        String word;
        int result =0;
        HashSet<String> hs = new HashSet<>();
        hs.add(beginWord);
        while(!q.isEmpty()){
            size = q.size();
            for(int i =0; i<size; i++){
                word = q.poll();
                if(word.equals(endWord))
                    return result +1;;
                for(int j =0; j<word.length(); j++){
                    modified = j +word.substring(0, j)+word.substring(j+1, word.length());
                    if(map.containsKey(modified)){
                        for(String s : map.get(modified)){
                            if(!hs.contains(s))
                                q.add(s);
                            hs.add(s);
                        }
                        map.remove(modified);
                    }
                }
            }
            result++;
        }
        return 0;
    }
}