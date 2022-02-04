package 其他;

import org.junit.Test;

public class T482 {
    @Test
    public void test(){
        System.out.println(licenseKeyFormatting("fdsws", 2));
    }
    public String licenseKeyFormatting(String ss, int k) {
        ss = ss.toUpperCase();
        ss = ss.replace("-","");
        StringBuffer s = new StringBuffer(ss);
        int s_length = s.length();
        int f_len = s_length%k;
        if(f_len!=0&&ss.length()>k) {
            s.insert(f_len, '-');
            f_len++;
        }
        int count = 0;
        for(int i = f_len ; i < s.length();i++){
            count++;
            if(count==k){
                count=0;
                if(i+1!=s.length()){
                    s.insert(i+1,'-');
                }
                i++;
            }
        }
        return new String(s);
    }
}
