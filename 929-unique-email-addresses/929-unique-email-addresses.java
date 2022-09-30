class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails){
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            String name = local[0].replace(".","");
            set.add(name +"@"+parts[1]);
        }
        return set.size();
    }
}