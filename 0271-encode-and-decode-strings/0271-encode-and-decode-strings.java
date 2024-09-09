public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs.size() == 0 || strs == null) return "";
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if(s.isEmpty()) return new ArrayList();
        List<String> strs = new ArrayList<>();

        int i = 0;
        int digit = 0;
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
                digit = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    digit = digit * 10 + (s.charAt(i) -'0');
                    i++;
                }
                i++;
                strs.add(s.substring(i, i+digit));
                i = i+digit;
            }
        }
        return strs;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));