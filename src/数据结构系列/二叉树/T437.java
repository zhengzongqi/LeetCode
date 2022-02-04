package 数据结构系列.二叉树;

public class T437 {

    //以root为根的二叉树，总共满足要求targetSum的路径数目
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        int res = 0;
        if(root.left!=null){res+=pathSum(root.left,targetSum);}
        if(root.right!=null){res+=pathSum(root.right,targetSum);}
        res+=getNumber(root,targetSum);
        return res;
    }

    //以root为起点，向下满足要求targetSum的路径数目
    public int getNumber(TreeNode root,int targetSum){
        int res = 0;
        if(root.val == targetSum){res++;}
        if(root.left!=null){res+=getNumber(root.left,targetSum-root.val);}
        if(root.right!=null){res+=getNumber(root.right,targetSum-root.val);}

        return res;
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
}
