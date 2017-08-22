package lingsan.cglibdemo;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * Created by liyanzhen on 17/1/9.
 */
public class InfoManagerFactory {
    private static InfoManager manager = new InfoManager();

    public static InfoManager getInstance() {
        return manager;
    }

    /**
     * +
     * 创建带有权限检验的InfoManager
     *
     * @param auth
     * @return
     */
    public static InfoManager getAuthInstance(AuthProxy auth) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(InfoManager.class);
        enhancer.setCallback(auth);
        return (InfoManager) enhancer.create();
    }

    public static InfoManager getSelectivityAuthInstance(AuthProxy auth){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(InfoManager.class);
        enhancer.setCallbacks(new Callback[]{
            auth, NoOp.INSTANCE
        });
        enhancer.setCallbackFilter(new AuthProxyFilter());
        return (InfoManager)enhancer.create();
    }
}
