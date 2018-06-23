package com.kuai.springboot.test.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc socket server
 * @since ${date}
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("端口已经打开，8888，开始接受数据");
        SocketWrapper socketWrapper = null;

        try {
            socketWrapper = new SocketWrapper(serverSocket.accept());

            String serverMessage = scanner.nextLine();
            /*socketWrapper.writeLine(serverMessage);
            String line = socketWrapper.readLine();*/
            while (!"bye".equals(serverMessage)) {
                System.out.println("client send message" + serverMessage);

                //向客户端发送信息
                socketWrapper.writeLine("我接受到你的 数据" + serverMessage);

                serverMessage = scanner.nextLine();
                System.out.println(serverMessage+ "----------");
                socketWrapper.writeLine(serverMessage );

                //读取客户端的信息
                serverMessage = socketWrapper.readLine();
            }
            //如果服务端向客户端发送close，标示关闭该客户端
            socketWrapper.writeLine("close");
        } catch (Exception e) {
            if (socketWrapper != null) {
                socketWrapper.close();
            }
        }
    }
}