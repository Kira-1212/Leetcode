// class Solution {
//     public String minRemoveToMakeValid(String s) {
//         Set<Integer> set = new HashSet<Integer>();
//         Stack<Integer> st = new Stack<>();

//         for(int i = 0; i<s.length(); i++){
//             char c = s.charAt(i);
//             if(c == '(')
//                 st.push(i);
//             if(c == ')'){
//                 if(st.isEmpty()){
//                     set.add(i);
//                 }
//                 else{
//                     st.pop();
//                 }
//             }

//         }
//         while(!st.isEmpty())
//             set.add(st.pop());
//         StringBuilder sb = new StringBuilder();

//         for(int i = 0; i<s.length(); i++){
//             if(!set.contains(i))
//                 sb.append(s.charAt(i));
//         }
//         return sb.toString();
//     }
// }

class Solution {
    public String minRemoveToMakeValid(String s) {
        int openSeen = 0;
        int balance = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                openSeen++;
                balance++;
            }
            if(c==')'){
                if(balance == 0)
                    continue;
                balance--;
            }
            sb.append(c);
        }
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for(int i = 0; i< sb.length(); i++){
            char c= sb.charAt(i);
            if(c == '('){
                openToKeep--;
                if(openToKeep < 0)continue;
            }
            result.append(c);
        }
        return result.toString();
    }
}