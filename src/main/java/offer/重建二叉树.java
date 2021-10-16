package lpl.offer;

import java.util.HashMap;

/**
 * @program: Algorithm
 * @description: 剑指 Offer 07. 重建二叉树
 * @author: 李沛隆21081020
 * @create: 2021-10-03 16:49
 */
public class 重建二叉树 {
    HashMap<Integer, Integer> dictionary = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            dictionary.put(inorder[i], i);
        }
        TreeNode root = myBuildTree(preorder, inorder, 0, preorder.length - 1, 0,
                preorder.length - 1);
        return root;
    }

    public TreeNode myBuildTree(int[] preorder,
                                int[] inorder,
                                int preLeftIndex,
                                int preRightIndex,
                                int inLeftIndex,
                                int inRightIndex) {
        if (preLeftIndex > preRightIndex) {
            return null;
        }
        int inorderRootIndex = dictionary.get(preorder[preLeftIndex]);
        TreeNode root = new TreeNode(preorder[preLeftIndex]);

        int leftTreeNodeNum = inorderRootIndex - inLeftIndex;

        root.left = myBuildTree(preorder, inorder, preLeftIndex + 1,
                preLeftIndex + leftTreeNodeNum, inLeftIndex, inorderRootIndex - 1);
        root.right = myBuildTree(preorder, inorder, preLeftIndex + 1 + leftTreeNodeNum,
                preRightIndex, inorderRootIndex + 1, inRightIndex);

        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
