package JVM.chaptertwo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by liyanzhen on 17/1/8.
 * jdk1.8没有PermGen
 * 借助CGLib使方法区出现内存溢出异常
 * VM Args:---XX:permSize=10M
 *           －XX:MaxpermSize=10M
 */
public class JavaMethodAreaOOM {
    public static void main(String args[]){
        while(true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor(){
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,objects);
                }
            });
            enhancer.create();
        }
    }
    static class OOMObject{}
}
