package lingsan.cglibdemo;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * +
 * Created by liyanzhen on 17/1/9.
 */
public class AuthProxy implements MethodInterceptor {
    private String name;

    public AuthProxy(String name){
        this.name = name;
    }

    /**
     * 权限校验，如果会员名为:maurice，则有权限做操作，否则提示没有权限
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (!"maurice".equals(this.name)){
            System.out.println("AuthProxy: you have no permits to do manager!");
            return null;
        }
        return methodProxy.invokeSuper(o,objects);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
