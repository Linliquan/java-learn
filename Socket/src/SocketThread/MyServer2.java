package SocketThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer2 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动");
        ServerSocket server = new ServerSocket(8099);

        while (true){
            //监听客户端连接
            Socket socket = server.accept();
        }
    }
}

//用来处理每次连接的客户端对象
class  My2 extends Thread{
    Socket socket;
    public My2(){

    }
}