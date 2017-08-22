package crazy;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by liyanzhen on 17/7/11.
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("www.baidu.com");
            System.out.println("crazy it 是否可达" + ip.isReachable(2000));
            System.out.println(ip.getHostAddress());
            System.out.println(ip.getCanonicalHostName());
            System.out.println(ip.getHostName());
            InetAddress local = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
            System.out.println("本机是否可达" + local.isReachable(5000));
            System.out.println(local.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
