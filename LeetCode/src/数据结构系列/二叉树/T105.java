package 数据结构系列.二叉树;

import org.junit.Test;

import java.util.Arrays;

public class T105 {
    @Test
    public void test(){
        TreeNode t = buildTree(new int[]{3,9,20,5,7},new int[]{9,3,15,20,7});
        System.out.println(1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null){
            return null;
        }
        return build(preorder,inorder);

    }
    //以preorder[idx_pre]为根节点，构造二叉树
    public TreeNode build(int[] preorder,int[] inorder){
        if(inorder.length==0){
            return null;
        }
        if(inorder.length==1){
            return new TreeNode(inorder[0]);
        }
        int idx_in = 0;
        TreeNode t = new TreeNode(preorder[idx_in]);
        while(inorder[idx_in]!=preorder[0]){
            idx_in++;
        }
        int[] left_pre = Arrays.copyOfRange(preorder,1,1+idx_in);
        int[] left = Arrays.copyOfRange(inorder,0,idx_in);
        t.left = build(left_pre,left);
        int[] right_pre = Arrays.copyOfRange(preorder,1+idx_in,preorder.length);
        int[] right = Arrays.copyOfRange(inorder,idx_in+1,inorder.length);
        t.right = build(right_pre,right);
        return t;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
