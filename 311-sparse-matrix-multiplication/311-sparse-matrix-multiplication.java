class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int n = mat1[0].length;
        int p = mat2[0].length;
        int[][] c = new int[m][p];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(mat1[i][j] != 0){
                    for(int k = 0; k<p; k++){
                        c[i][k] += mat1[i][j] * mat2[j][k];
                    }
                }
            }
        }
        return c;
    }
}