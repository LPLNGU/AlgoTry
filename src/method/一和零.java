package method;/** * <p> * leeconde:474. 一和零 * </p> * * @author lipeilong * @time 2020/9/15 16:48 * @description leeconde:474. 一和零 */public class 一和零 {    public static void main(String[] args) {        String[] test = {"10", "0001", "111001", "1", "0"};        //System.out.println(findMaxForm(test, 5, 3));    }    public int findMaxForm(String[] strs, int m, int n) {        //k表示到达k-1的字符，i是剩余0个数，j是剩余1个数        int length = strs.length;        int[][][] nums = new int[length + 1][m + 1][n + 1];        for (int k = 1; k <= length; k++) {            int[] count01 = count01(strs[k - 1]);            for (int i = 0; i <= m; i++) {                for (int j = 0; j <= n; j++) {                    nums[k][i][j] = nums[k - 1][i][j];                    if (count01[0] <= i && count01[1] <= j) {                        nums[k][i][j] = Math.max(nums[k - 1][i][j], nums[k - 1][i - count01[0]][j - count01[1]] + 1);                    }                }            }        }        return nums[length][m][n];    }    private int[] count01(String string) {        int[] res = new int[2];        for (char c : string.toCharArray()) {            res[c - '0']++;        }        return res;    }}