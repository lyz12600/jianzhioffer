package multithread.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySever {
    public static List<Socket> socketsList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(30000);
        while (true) {
            Socket s = ss.accept();
            socketsList.add(s);
            new Thread(new ServerThread(s)).start();
        }
    }
}
