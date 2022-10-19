package 笔试题;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class A{
    private String name = "A";
    A(){
        S();
    }

    public void S(){
        System.out.println("A"+name);
    }
}

public class 微众1{
    public static void main(String[] args){
        byte b = 1;
        int i = 10;
        b = (byte) (b+b);
        i=b+i;
        System.out.println(b + ""+i);
    }
}
class B extends A {
    private String name = "B";
    B(){
        S();
    }

    public void S(){
        System.out.println("B"+name);
    }
}

