package 数据结构系列.二叉树;

import java.util.ArrayList;
import java.util.List;

public class Offer34 {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        if(root==null){
            return res;
        }
        backTrace(root,target,new ArrayList<>());

        return res;
    }

    public void backTrace(TreeNode root, int target, List<Integer> record){
        if(root.val == target && root.left == null && root.right == null){
            record.add(root.val);
            res.add(new ArrayList<>(record));
            record.remove(record.size()-1);
        }
        if(root.left!=null){
            record.add(root.val);
            backTrace(root.left,target-root.val,record);
            record.remove(record.size()-1);
        }
        if(root.right!=null){
            record.add(root.val);
            backTrace(root.right,target-root.val,record);
            record.remove(record.size()-1);
        }
    }
}
