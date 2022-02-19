package 其他;

public class T1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int maxlen = 1;
        int maxlencount = 0;
        for(int i = 0 ;i< rectangles.length;i++){
            int len = Math.min(rectangles[i][0],rectangles[i][1]);
            if(len>maxlen){
                maxlen = len;
                maxlencount = 1;
            }
            else if(len == maxlen){
                maxlencount++;
            }
        }
        return maxlencount;
    }
}
