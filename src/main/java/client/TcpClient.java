package main.java.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Auther: GEEX1428
 * @Date: 2021/11/8 18:33
 * @Description: TCP客户端
 */
public class TcpClient {

    public static void main(String[] args) throws IOException {
        //设置host
        String host = "127.0.0.1";
        //设置端口
        int port = 8888;
        //获取控制台输入数据流
        BufferedReader readerUser = new BufferedReader(new InputStreamReader(System.in));
        //根据host,port创建连接
        Socket socket = new Socket(host,port);
        String text = readerUser.readLine();

        //获取socket内部持有输出流
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        //以字节格式，输出数据到server
        dataOutputStream.writeBytes(text+'\n');


        //读取server处理后的数据
        BufferedReader readerServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String text1 = readerServer.readLine();
        //打印
        System.out.println("from server:"+text1);
        //关闭连接
        socket.close();
    }
}
