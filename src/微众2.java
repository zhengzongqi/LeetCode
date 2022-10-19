import org.junit.Test;

import java.util.*;

public class 微众2 {
    static Deque<Integer> queue = new LinkedList<>();
    static int[] markleft;
    static int[] markright;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] people = new int[n];
        markleft = new int[n];
        markright = new int[n];
        for(int i = 0;i<n;i++){
            people[i] = sc.nextInt();
        }

        int[] ltor = getSildeWindowleft(people,x);
        Deque<Integer> queue = new LinkedList<>();
        int[] rtol = getSildeWindowright(people,y);

        for(int i = 0;i<people.length;i++){
            if(ltor[i]>people[i]&&rtol[i]>people[i]){
                System.out.println(i+1);
                return;
            }
            else if(ltor[i]==people[i]&&rtol[i]==people[i]){
                boolean hasres = true;
                for(int ii = 1;ii<=x;ii++){
                    if(i-ii>=0&&people[i-ii]<=people[i]){
                        hasres = false;
                    }
                }
                for(int ii = 1;ii<=y;ii++){
                    if(i+ii<people.length&&people[i+ii]<=people[i]){
                        hasres = false;
                    }
                }
                if(hasres==true){
                    System.out.println(i+1);
                    return;
                }
            }
        }

    }

    public static int[] getSildeWindowleft(int[] people,int x){
        int[] res = new int[people.length];
        int min = people[0];
        for(int i = 0;i<x;i++){
            min = Math.min(min,people[i]);
            res[i] = min;
        }
        for(int i = 0;i<people.length;i++){
            if(i<x-1){
                queue_push(people[i]);
            }
            else{
                queue_push(people[i]);
                //res[i] = queue_getmin();
                int nn = queue_getmin();
                if(res[i]==nn){
                    markleft[i] = 1;
                }
                res[i] = nn;
                queue_pop(people[i-x+1]);
            }
        }
        return res;
    }
    public static int[] getSildeWindowright(int[] people,int x){
        int[] res = new int[people.length];
        int len = people.length;
        int min = people[len-1];
        for(int i = len-1;i>len-1-x;i--){
            min = Math.min(min,people[i]);
            res[i] = min;
        }
        for(int i = len-1;i>=0;i--){
            if(i>len-x-1){
                queue_push(people[i]);
            }
            else{
                queue_push(people[i]);
//                res[i] = queue_getmin();
                int nn = queue_getmin();
                if(res[i]==nn){
                    markright[i] = 1;
                }
                res[i] = nn;
                queue_pop(people[i+x-1]);
            }
        }
        return res;
    }
    public static void queue_push(int i){
        while (!queue.isEmpty()&&queue.peek()>i){
            queue.pollLast();
        }
        queue.offer(i);
    }
    public static int queue_getmin(){
        return queue.peek();
    }
    public static void queue_pop(int i){
        if(i==queue.peek()){
            queue.poll();
        }
    }


}
