package 其他;

import java.util.Arrays;

public class T455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int gidx=0;
        int sidx = 0;
        while(gidx<g.length&&sidx<s.length){
            if(g[gidx]<=s[sidx]){
                res++;
                gidx++;
                sidx++;
            }
            else{
                sidx++;
            }
        }
        return res;
    }
}
