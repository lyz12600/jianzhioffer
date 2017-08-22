package multithread.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by liyanzhen on 17/7/11.
 */
public class ServerThread implements Runnable {
    Socket s = null;
    BufferedReader br = null;

    public ServerThread(Socket s) throws Exception {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        String content = null;
        while ((content = readFromClent()) != null) {
            for (Socket s : MySever.socketsList) {
                try {
                    PrintStream ps = new PrintStream(s.getOutputStream());
                    ps.println(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String readFromClent() {
        try {
            String str = br.readLine();
            System.out.println(str);
            return str;
        } catch (IOException e) {
            MySever.socketsList.remove(s);
        }
        return null;
    }
}
