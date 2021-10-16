package lpl.offer;

/**
 * @program: Algorithm
 * @description: 剑指offer04
 * @author: 李沛隆21081020
 * @create: 2021-10-03 11:36
 */
public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || target == 0 || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = col - 1;
        while (i != matrix.length && j != -1) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
