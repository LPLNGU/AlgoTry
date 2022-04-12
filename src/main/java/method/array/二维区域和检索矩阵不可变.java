package method.array;

/**
 * @program: suanfati
 * @description: 304
 * @author: 李沛隆21081020
 * @create: 2022-04-08 17:37
 */
public class 二维区域和检索矩阵不可变 {
    private int[][] preSum;

    //构造函数
    public 二维区域和检索矩阵不可变(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0) {
            return;
        }
        //preSum比矩阵行列大1
        preSum = new int[m + 1][n + 1];
        //p[i][j] = sum([0][0]->[i-1][j-1])
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];
    }
}
