package 数据结构系列;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Offer31 {
    @Test
    public void test(){
        validateStackSequences(new int[]{1,2,3,4},new int[]{3,1,2,4});
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int idx1 = 0;
        int idx2 = 0;
        while(idx1<=pushed.length-1||idx2<=popped.length-1){
            while(stack.isEmpty()||stack.peek()!=popped[idx2]){
                if(idx1>=pushed.length){
                    break;
                }
                stack.push(pushed[idx1++]);
            }
            while(!stack.isEmpty()&&stack.peek()==popped[idx2]){
                stack.poll();
                idx2++;
            }
            if(idx1==pushed.length&&idx2!=popped.length){
                return false;
            }
        }
        return true;
    }
}
