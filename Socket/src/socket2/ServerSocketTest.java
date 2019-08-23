package socket2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
    public static void main(String[] args) {
        System.out.println("服务器端启动");

        try {
            //初始化服务器端socket并绑定端口9999
            ServerSocket serverSocket = new ServerSocket(9999);

            //等待客户端的连接
            Socket socket = serverSocket.accept();

            //获取输入流,
            // InputStreamReader:将字节流转化为字符流，
            // OutputStreamWrite是将字符流转换为字节流
            //BufferedWriter 和 BufferedReader 为带有默认缓冲的字符输出输入流，因为有缓冲区所以很效率比没有缓冲区的很高。
            //BufferedReader:将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //读取一行数据
            String str = bufferedReader.readLine();

            //输出打印
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
