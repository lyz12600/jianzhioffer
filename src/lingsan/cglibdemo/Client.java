package lingsan.cglibdemo;

/**
 * Created by liyanzhen on 17/1/9.
 */
public class Client {
    private void doCRUD(InfoManager manager){
        manager.create();
        manager.update();
        manager.query();
        manager.delete();
    }

    private void separatorLine(){
        System.out.println("############################");
    }

    public static void main(String args[]){
        Client client = new Client();
        //client.havaAuthManager();
        //client.havaNoAuthManager();
        client.selectiviyAuthManager();
    }

    /**
     * ++
     * 模拟没有权限的会员，可以做查询操作
     *
     */
    public void selectiviyAuthManager(){
        System.out.println("the loginer's name is not maurice,so have no permits do manager except do query operator");
        InfoManager authManager = InfoManagerFactory.getSelectivityAuthInstance(new AuthProxy("mauricel"));
        doCRUD(authManager);
        separatorLine();
    }

    /**
     * +
     */
    public void havaNoAuthManager(){
        System.out.println("the loginer's name is not mauticel,so have no permits do manager");
        InfoManager noAuthManager = InfoManagerFactory.getAuthInstance(new AuthProxy("mauricel"));
        doCRUD(noAuthManager);
        separatorLine();
    }

    /**
     * +
     */
    public void havaAuthManager(){
        System.out.println("have permits do manger");
        InfoManager manager = InfoManagerFactory.getAuthInstance(new AuthProxy("maurice"));
        doCRUD(manager);
        separatorLine();
    }
}
