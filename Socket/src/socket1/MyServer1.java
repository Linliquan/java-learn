package socket1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer1 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动！");
        ServerSocket server = new ServerSocket(8099);

        //
        Socket socket  = server.accept();
        OutputStream out = socket.getOutputStream();
        out.write("小明你好1".getBytes());
        out.write("哈哈".getBytes());

    }
}
