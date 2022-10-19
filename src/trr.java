

import java.util.*;


public class trr{

    public static void main(String[] args){
        int x = 1,y = 1,z = 1;
        if(--x==0&&y++==1||z++==1)
            System.out.println(x+" "+ y + " "+z);
    }

    static class a{
        public static String o = "";

        public static void foo(int i){
            try {
                if(i==1){
                    throw new ArithmeticException();
                }
            }
            catch (Exception e){
                o+="3";
                return;
            }
            finally {
                o+="2";
            }
            o+=1;
        }
    }

    static class b extends a{
        public b(){
            System.out.println(4);
        }
        {
            System.out.println(5);
        }
        static {
            System.out.println(6);
        }
    }














}





















