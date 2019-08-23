package socket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyClient1 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端连接");
        Socket socket = new Socket("127.0.0.1",8099);

        //常用代码
        InputStream in = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(in,"UTF-8");
        BufferedReader br = new BufferedReader(isr);

        System.out.println(br.readLine());
        System.out.println(br.readLine());

        br.close();
        isr.close();
        in.close();

    }
}
