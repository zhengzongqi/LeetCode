package JVM;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class 动态代理 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animals a =(Animals) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),Dog.class.getInterfaces(),new animalsInvocationHandler(dog));
        a.eat(4);

    }

    public interface Animals{
        public void eat(int number);
    }

    public static class Dog implements  Animals{
        @Override
        public void eat(int number) {
            System.out.println("eat 骨头 ,数量："+number);
        }
    }

    public static class animalsInvocationHandler implements InvocationHandler{
        Object obj;
        public animalsInvocationHandler(Object o){
            this.obj = o;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("prev");
            Object res = method.invoke(obj,args);
            System.out.println("end");
            return res;
        }
    }

}
