package DFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class T684 {
    @Test
    public void test(){
        int[][] e = new int[][]{{1,2},{1,3},{2,3}};
        int[] res = findRedundantConnection(e);
        System.out.println(res[0]+ " " +res[1]);
    }

    int size;
    ListNode[] V;
    public int[] findRedundantConnection(int[][] edges) {
        size = edges.length;
        V = new ListNode[edges.length+1];
        for(int i = 1;i<=edges.length;i++){
            V[i] = new ListNode(i);
        }
        for(int i = 0;i<edges.length;i++){
            int[] edge = edges[i];
            V[edge[0]].neigbor.add(V[edge[1]]);
            V[edge[1]].neigbor.add(V[edge[0]]);
        }

        for(int i = edges.length-1;i>=0;i--){
            int[] edge = edges[i];
            V[edge[0]].neigbor.remove(V[edge[1]]);
            V[edge[1]].neigbor.remove(V[edge[0]]);
            if(DFS(1,new int[size+1])==size){
                return edge;
            }
            V[edge[0]].neigbor.add(V[edge[1]]);
            V[edge[1]].neigbor.add(V[edge[0]]);
        }
        return new int[]{0,0};

    }

    public int DFS(int nodeidx,int[] hasreversed){
        hasreversed[nodeidx] = 1;
        ListNode node = V[nodeidx];
        int linknum = 1;
        for(int i =0;i<node.neigbor.size();i++){
            ListNode n = node.neigbor.get(i);
            if(hasreversed[n.val]==0){
                linknum += DFS(n.val,hasreversed);
                //hasreversed[n.val]=0;
            }
        }
        return linknum;
    }


    class ListNode{
        public int val;
        public List<ListNode> neigbor;
        public ListNode(int v){
            val = v;
            neigbor = new ArrayList<ListNode>();
        }
    }
}
