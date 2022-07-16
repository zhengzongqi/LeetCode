
    import java.util.*;
    import java.math.BigInteger;

    public class 微众3 {

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            int res = 0;
            String s = sc.nextLine();
            Map<String,Boolean> hashMap = new HashMap<>();
            BigInteger kk = BigInteger.valueOf(k);
            BigInteger zero = BigInteger.valueOf(0);


            for(int i=0;i<s.length();i++){
                for(int j=i+1;j<=s.length();j++){
                    String temp = s.substring(i,j);
                    if(hashMap.containsKey(temp)){
                        res++;
                        continue;
                    }
                    BigInteger one = new BigInteger(temp);
                    if(one.divideAndRemainder(kk)[1].equals(zero)){
                        hashMap.put(temp,true);
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }
