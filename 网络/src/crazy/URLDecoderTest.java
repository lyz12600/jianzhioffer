package crazy;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by liyanzhen on 17/7/11.
 */
public class URLDecoderTest {
    public static void main(String[] args) {
        try {
            String keyword = URLDecoder.decode("%E7%96%AF%E7%8B%82java", "utf-8");
            System.out.println(keyword);

            String urlStr = URLEncoder.encode("疯狂java", "utf-8");
            System.out.println(urlStr);

            System.out.println(keyword.equals("疯狂java"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
