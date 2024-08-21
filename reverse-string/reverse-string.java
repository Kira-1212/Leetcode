class Solution {
    public void reverseString(char[] s) {
        swap(0, s.length-1, s);
    }
    private void swap(int l, int r, char[] s){
        while(l<r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}