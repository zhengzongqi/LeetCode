package 其他;

import java.util.ArrayList;
import java.util.List;

public class T1447 {

    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<String>();
        for(int i = 1;i<n;i++){
            for(int j = i+1;j<=n;j++){
                if(check(i,j)==true){
                    res.add(i+"/"+j);
                }
            }
        }
        return res;
    }

    private boolean check(int i ,int j){
        if(i==1){
            return true;
        }
        int res = j;
        while(res!=0&&res!=1){
            res = j%i;
            j=i;
            i=res;
        }
        return res==0?false:true;
    }
}
