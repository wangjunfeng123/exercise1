package com.kuai.springboot.test.socket;

import java.io.*;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class Demo1FileInputStream {
    // demo 1
    /*public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("c:/zz.txt");
        int x ;
        while ((x= fileInputStream.read()) != -1) {
            System.out.println(x);
        }
        fileInputStream.close();
    }*/

    // demo 2
    /*public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("ff.txt");
        fileOutputStream.write(97);
        fileOutputStream.write(98);
        fileOutputStream.write(99);

        fileOutputStream.close();
    }*/

  /* public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("ff.txt",true);
        fileOutputStream.write(97);
        fileOutputStream.write(98);
        fileOutputStream.write(99);

        fileOutputStream.close();
    }*/

    /*public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("copy.jpg");
        FileInputStream fileInputStream = new FileInputStream("ooo.jpg");

        int x;
        while ((x = fileInputStream.read()) != -1) {
            fileOutputStream.write(x);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }*/

   /* public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("copy.jpg");
        FileInputStream fileInputStream = new FileInputStream("ooo.jpg");
        byte[] arr = new byte[1000*4];
        int b;
        while ((b = fileInputStream.read(arr)) != -1) {
            fileOutputStream.write(arr,0,b);
        }
        fileInputStream.close();
        fileOutputStream.close();

    }*/

    /*public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("copy.jpg");
        FileInputStream fileInputStream = new FileInputStream("ooo.jpg");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] arr = new byte[1000*4];
        int b;
        while ((b = bufferedInputStream.read(arr)) != -1) {
            bufferedOutputStream.write(arr,0,b);
        }
        bufferedOutputStream.flush();
        fileInputStream.close();
        fileOutputStream.close();

    }*/

    public static void main(String[] args) {
        try ( FileOutputStream fileOutputStream = new FileOutputStream("copy.jpg");
              FileInputStream fileInputStream = new FileInputStream("ooo.jpg");
        ){
            int b;
            while ((b = fileInputStream.read()) != 1) {
                fileOutputStream.write(b);
            }
        } catch (IOException e) {
            //异常处理
        }
    }
}