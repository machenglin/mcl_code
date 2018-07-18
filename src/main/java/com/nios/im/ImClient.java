package com.nios.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by machenglin on 2018/6/17.
 */
public class ImClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.59", 7731);
        System.out.println("连接成功");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("hi");
        printWriter.flush();
        byte[] buf = new byte[2048];
        System.out.println("准备读取数据~~");

        while(true){
            try {
                //两种读取数据方式
                int count = socket.getInputStream().read(buf);        //会阻塞
                //String readFromServer = bufferedReader.readLine();//可以读取到数据 会阻塞,直到遇见\n
                //System.out.println("方式二： 读取数据" + readFromServer);
                System.out.println(new String(buf));
                Thread.sleep(1*1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //break;
        }
    }


}
