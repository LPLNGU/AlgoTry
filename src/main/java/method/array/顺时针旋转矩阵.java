package method.array;

/**
 * @program: suanfati
 * @description: 牛客 BM99 顺时针旋转矩阵
 * @author: 李沛隆21081020
 * @create: 2022-04-19 19:51
 */
public class 顺时针旋转矩阵 {
    public int[][] rotateMatrix(int[][] mat, int n) {
        int tmp;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
        for (int[] ints : mat) {
            reverse(ints);
        }
        return mat;
    }

    //反转数组，直接使用双指针
    public int[] reverse(int[] arr) {
        int tmp, left = 0, right = arr.length - 1;
        while (left < right) {
            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        return arr;
    }
}
