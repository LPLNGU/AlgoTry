package method;

import java.util.Arrays;

/**
 * <p>牛客 NC242 单词搜索</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2023-12-05 19:51
 */
public class 单词搜索 {

//    public static void main(String[] args) {
//        String[] board = {"XYZE", "SFZS", "XDEE"};
//        String word = "XYZZED";
//        System.out.println(exist(board, word));
//    }

    public boolean exist(String[] board, String word) {
        // write code here
        char[][] charBoard = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            charBoard[i] = board[i].toCharArray();
        }
        System.out.println("charBoard:" + Arrays.deepToString(charBoard) + " board:" + Arrays.toString(board));
        //错误点，开始只进行了单次的dfs方法调用遍历，也就是只遍历了board[0][0]为开始的序列，后发现需要以每个元素为开始尝试遍历。
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (dfs(charBoard, word, i, j, 0)) {
                    return true;
                }
            }
        }
        System.out.println("charBoard:" + Arrays.deepToString(charBoard) + " board:" + Arrays.toString(board));
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int wordIndex) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(wordIndex)) {
            return false;
        }
        if (wordIndex == word.length() - 1) {
            return true;
        }
        board[i][j] = ' ';
        //错误点，这里开始用的++wordIndex，但是发现后面输出的赋值是有问题的，后续对比答案修改
        boolean result = dfs(board, word, i - 1, j, wordIndex + 1) ||
                dfs(board, word, i, j - 1, wordIndex + 1) ||
                dfs(board, word, i + 1, j, wordIndex + 1) ||
                dfs(board, word, i, j + 1, wordIndex + 1);
        board[i][j] = word.charAt(wordIndex);
        return result;
    }


}
