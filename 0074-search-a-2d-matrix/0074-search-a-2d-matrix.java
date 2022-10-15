class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int low = 0;
        int high = matrix.length * matrix[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / matrix[0].length;
            int c = mid % matrix[0].length;
            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] < target)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return false;
    }
}