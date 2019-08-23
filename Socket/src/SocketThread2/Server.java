package SocketThread2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        System.out.println("服务器启动成功");

            ServerSocket serverSocket = new ServerSocket(9999);

            while (true){
                //等待客户端的连接
                Socket socket = serverSocket.accept();


                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        BufferedReader bufferedReader = null;
                        try {
                             bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));

                             String str;

                             while ((str = bufferedReader.readLine()) != null){
                                 System.out.println("客户端说："+str);
                             }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }





    }
}
