    import java.util.Scanner;

    public class 百度2 {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int[] A = new int[N];
            int[] B = new int[N];
            for(int i = 0;i<N;i++){
                A[i] = sc.nextInt();
                B[i] = sc.nextInt();
            }
            res = Integer.MAX_VALUE;
            backTrack(A,B,N,0,0,new int[N],0);
            System.out.println(res);

        }
        static int res;
        public static void backTrack(int[] A,int[] B,int N,int day,int cost,int[] buyinfo,int buycount){
            if(buycount>=N){
                res = Math.min(res,cost);
            }
            if(cost>=res){
                return;
            }
            for(int i = 0;i<N;i++){
                //尝试买第i件商品
                if(buyinfo[i] == 0 ){
                    buyinfo[i] = 1;
                    int newcost = cost + A[i]+B[i]*day;
                    //如果是奇数，尝试选一件免费商品
                    if(day%2==1){
                        if(buycount==N-1){
                            res = Math.min(res,newcost);
                            buyinfo[i] = 0;
                            continue;
                        }
                        for(int j = 0;j<N;j++){
                            if(buyinfo[j] == 0 ){
                                buyinfo[j] = 1;
                                backTrack(A,B,N,day+1,newcost,buyinfo,buycount+2);
                                buyinfo[j] = 0;
                            }
                        }
                        buyinfo[i]=0;
                    }
                    else{
                        backTrack(A,B,N,day+1,newcost,buyinfo,buycount+1);
                        buyinfo[i] = 0;
                    }
                }
            }
        }
    }
