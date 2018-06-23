package com.kuai.springboot.test.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc socket client
 * @since ${date}
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        SocketWrapper socketWrapper = new SocketWrapper(new Socket("localhost", 8888));

        try {
            System.out.println("已经连接上服务器，现在可以开始通讯");
            String sendMessage = scanner.nextLine();
            socketWrapper.writeLine(sendMessage);

            //recived message
            String reviceMessage = socketWrapper.readLine();

            while (!"close".equals(reviceMessage)) {
                System.out.println("【服务端返回的信息】"+ reviceMessage);

                //send message
                sendMessage = scanner.nextLine();
                socketWrapper.writeLine(sendMessage);

                reviceMessage = socketWrapper.readLine();
            }
        } catch (Exception e) {
        }finally {
            if (socketWrapper != null) {
                socketWrapper.close();
            }
        }
    }
}