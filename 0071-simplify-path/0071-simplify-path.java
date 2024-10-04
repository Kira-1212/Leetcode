class Solution {
    public String simplifyPath(String path) {
        String[] directories = path.split("/");

        Stack<String> s = new Stack<>();
        for(String directory : directories){
            if(directory.isEmpty()||directory.equals("."))
                continue;
            else if(directory.equals("..")){
                if(!s.isEmpty())
                    s.pop();
            }
            else
                s.add(directory);
        }
        StringBuilder sb = new StringBuilder();
        for(String st : s){
            sb.append("/");
            sb.append(st);
        }

        return sb.length()>0 ? sb.toString() : "/";
    }
}