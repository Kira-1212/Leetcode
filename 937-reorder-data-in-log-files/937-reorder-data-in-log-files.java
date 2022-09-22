class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0 )return new String[]{};
        Arrays.sort(logs, (s1,s2) -> {
            String[] str1 = s1.split(" ", 2);
            String[] str2 = s2.split(" ", 2);
            boolean isD1 = Character.isDigit(str1[1].charAt(0));
            boolean isD2 = Character.isDigit(str2[1].charAt(0));
            if(!isD1 && !isD2){
                int cmp = str1[1].compareTo(str2[1]);
                if(cmp ==0){
                    return str1[0].compareTo(str2[0]);
                }
                return cmp;
            }
            else if(!isD1 && isD2){
                return -1;
            }
            else if(isD1 && !isD2){
                return 1;
            }
            else{
                return 0;
            }
        });
        return logs;
    }
}