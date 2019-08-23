package socketwhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("服务器端已启动");
        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            //等待服务器连接
            Socket socket = serverSocket.accept();

            //  获取输入流，并且使用统一的编码
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));

            //读取一行
            String str;

            //通过while循环不断读取信息
            while((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
