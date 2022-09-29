class Solution {
    public int[] replaceElements(int[] arr) {
        if(arr.length == 1)return new int[]{-1};
        int n = arr.length;
        int max = arr[n-1];
        arr[n-1] = -1;
        for(int i = n-2; i>=0; i--){
            int temp = max;
            
            max = Math.max(max, arr[i]);
            arr[i] = temp;
        }
        return arr;
    }
}