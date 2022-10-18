class Solution {
    int m, n, color;
    int[][] dirs;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor)
            return image;
        m = image.length;
        n = image[0].length;
        dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        color = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;

    }

    public void dfs(int[][] image, int sr, int sc, int newColor) {
        if (sc < 0 || sr < 0 || sr == m || sc == n || image[sr][sc] != color)
            return;

        image[sr][sc] = newColor;
        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, newColor);
        }
    }
}