package com.kuai.springboot.test.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc socket的重要参数：
 *      是否能连通，
 *      心跳，
 *      对方是否已经关闭程序
 * @since ${date}
 */
public class SocketWrapper {

    private Socket socket;

    private InputStream inputStream;
    private BufferedReader inputReader;
    private BufferedWriter outWriter;

    public SocketWrapper(Socket socket) throws IOException {
        this.socket = socket;
        this.inputStream = socket.getInputStream();
        this.inputReader = new BufferedReader(new InputStreamReader(inputStream,"GBK"));
        this.outWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"GBK"));
    }

    public String readLine() throws IOException {
        return inputReader.readLine();
    }

    public void writeLine(String line) throws IOException {
        outWriter.write(line + "\n");
        outWriter.flush();
    }

    public void close() {
        try {
            this.socket.close();
        } catch (Exception e) {
            //this body code need you write
        }
    }
}