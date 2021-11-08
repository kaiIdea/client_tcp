package main.java.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/8 18:34
 * @Description: TCP服务端
 */
public class TcpServer {

    public static void main(String[] args) throws IOException {
        //设置监听端口
        int port = 8888;
        //创建server服务,内部方法做bind，端口绑定，监听
        ServerSocket serverSocket = new ServerSocket(port);
        //获取socket连接
        Socket socket = serverSocket.accept();
        //获取socket输入流
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String text =reader.readLine();
        System.out.println(text);
        //获取socket 内部持有的输出流
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        //对客户端传送过来的数据做处理
        String text1= text.toUpperCase()+'\n';
        //讲处理过后的数据，以字节格式写回流中，传回客户端
        outputStream.writeBytes(text1);
    }
}
