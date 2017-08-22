package lingsan.cglibdemo;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * ++
 * Created by liyanzhen on 17/1/9.
 */
public class AuthProxyFilter implements CallbackFilter {
    private static final int AUTH_NEED = 0;
    private static final int AUTH_NOT_NEED = 1;

    @Override
    public int accept(Method method) {
        if ("query".equals(method.getName())){
            return AUTH_NOT_NEED;
        }
        return AUTH_NEED;
    }
}
