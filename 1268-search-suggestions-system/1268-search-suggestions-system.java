class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        int l = 0;
        int r = products.length-1;
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        for(int i = 0; i<searchWord.length(); i++){
            char c = searchWord.charAt(i);
            while(l<=r && (products[l].length() <=i || products[l].charAt(i) != c))
                  l++;
            while(l<=r && (products[r].length() <=i || products[r].charAt(i) != c))
                  r--;
            int remain = r-l+1;
            res.add(new ArrayList<>());
            for(int j =0; j<Math.min(remain,3); j++){
                res.get(res.size()-1).add(products[l+j]);
            }
        }
        return res;
    }
}