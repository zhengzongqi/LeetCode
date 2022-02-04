package 数据结构系列.二叉树;

import java.util.HashSet;
import java.util.Set;

public class T1361 {

    /*
    * 先对每个节点进行遍历，如果在遍历过程中出现了已经遍历过的结点，说明有环，返回false
    * 在遍历过程中，使用max_link标记从每个节点开始，进行n遍遍历时，单次遍历能访问的节点最大值，倘若结果为二叉树，那么从根节点开始访问时，max_link=n;如果max_link小于n，那么说明树是断的，返回false
    * */
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        visited = new HashSet<>();
        for(int i = 0 ; i < n ;i++){
            visited.clear();
            if(travelse(i,leftChild,rightChild)==false){
                return false;
            }
            max_link = Math.max(visited.size(),max_link);
        }

        if(max_link!=n){
            return false;
        }
        else{
            return true;
        }

    }

    Set<Integer> visited;
    int max_link = 0;

    public boolean travelse(int i,int[] leftChild, int[] rightChild){
        if(i==-1){
            return true;
        }
        if(visited.contains(i)){
            return false;
        }
        else{
            visited.add(i);
            return travelse(leftChild[i],leftChild,rightChild)&&travelse(rightChild[i],leftChild,rightChild);
        }
    }
}
