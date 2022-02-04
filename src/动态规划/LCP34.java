package 动态规划;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCP34 {

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t6.left=t2;
        t6.right=t7;
        t2.left=t1;
        t2.right=t4;
        t4.left = t3;
        t4.right = t5;
        t7.left = t8;
//        TreeNode t1 = new TreeNode(5);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(4);
//        TreeNode t4 = new TreeNode(3);
//        t1.left=t2;
//        t2.left=t3;
//        t1.right = t4;

        System.out.println(maxValue(t6,2));
    }

    Map<TreeNode,Integer[]> map = new HashMap<>();
    public int maxValue(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        int sfsd = root.val;
        maxValue(root.left,k);
        maxValue(root.right,k);

        Integer[] dp = new Integer[k+1];
        Arrays.fill(dp,0);
        if(root.left==null&&root.right==null){
            Arrays.fill(dp,root.val);
            dp[0]=0;
        }
        else if(root.left==null){
            Integer[] dp_ = map.get(root.right);
            dp[0] = dp_[k];
            for(int i = 1;i<=k;i++){
                dp[i] = Math.max(dp[i-1],root.val+dp_[i-1]);
            }
        }
        else if(root.right==null){
            Integer[] dp_ = map.get(root.left);
            dp[0] = dp_[k];
            for(int i = 1;i<=k;i++){
                dp[i] =Math.max(dp[i-1],root.val+dp_[i-1]);
            }
        }
        else{
            Integer[] dp_l = map.get(root.left);
            Integer[] dp_r = map.get(root.right);
            dp[0] = dp_l[k]+dp_r[k];
            for(int i = 1 ;i<=k;i++){
                //染色当前结点
                int use = 0;
                for(int ii = 0;ii<i;ii++){
                    use = Math.max(dp_l[ii]+dp_r[i-ii-1]+root.val,use);
                }
                dp[i] = Math.max(dp[i-1],use);
            }
        }
        map.put(root,dp);
        return map.get(root)[k];
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

}
