package 其他;

public class T506 {
    public String[] findRelativeRanks(int[] score) {
        int[] idx_record = new int[score.length];
        for(int i = 0;i<score.length;i++){
            idx_record[i] = i;
        }
        for(int i = 0 ;i<score.length;i++){
            int pos = i;
            for(int j = i+1;j<score.length;j++){
                if(score[i]<score[j]){
                    int temp =score[i];
                    score[i] = score[j];
                    score[j] = temp;
                    temp = idx_record[i];
                    idx_record[i] = idx_record[j];
                    idx_record[j] = temp;
                }
            }
        }
        String[] res = new String[score.length];
        for(int i = 0;i<score.length;i++){
            int idx = idx_record[i];
            String th = "";
            if(i==0){th = "Gold Medal";}
            else if(i==1){th = "Silver Medal";}
            else if(i==2){th = "Bronze Medal";}
            else{th = String.valueOf(i+1);}
            res[idx] = th;
        }
        return res;
    }
}
