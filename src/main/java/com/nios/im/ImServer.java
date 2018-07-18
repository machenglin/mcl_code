package com.nios.im;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by machenglin on 2018/6/17.
 */
public class ImServer implements Runnable {

    @Override
    public void run() {
        init();
    }

    private void init() {
        try {
            // 创建通道和选择器
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            Selector selector = Selector.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(
                    InetAddress.getLocalHost(), 7731);
            serverSocketChannel.socket().bind(inetSocketAddress);
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server started .... port:7731");
            listener(selector);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listener(Selector selector) {
        try {
            while (true) {
                Thread.sleep(1 * 1000);
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
                while (selectionKeyIterator.hasNext()) {
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    if (selectionKey.isAcceptable()) {
                        System.out.println("接受请求事件");
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                        serverSocketChannel
                                .accept()
                                .configureBlocking(false)
                                .register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
                        System.out.println("已连接");
                    }
                    if (selectionKey.isReadable()) {// 读数据
                        SocketChannel clientChannel=(SocketChannel)selectionKey.channel();
                        ByteBuffer receiveBuf = ByteBuffer.allocate(2048);
                        clientChannel.read(receiveBuf);
                        System.out.println( getString(receiveBuf));
                    }
                    if(selectionKey.isWritable()){// 写数据
                        Scanner sc = new Scanner(System.in);
                        SocketChannel clientChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer sendBuf = ByteBuffer.allocate(2048);
                        sendBuf.put(sc.next().getBytes());
                        sendBuf.flip();        //写完数据后调用此方法
                        clientChannel.write(sendBuf);
                    }
                    if (selectionKey.isConnectable()) {
                        System.out.println(selectionKey.attachment()
                                + " - 连接事件");
                    }
                    // 必须removed 否则会继续存在，下一次循环还会进来,
                    // 注意removed 的位置，针对一个.next() remove一次
                    selectionKeyIterator.remove();

                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static String getString(ByteBuffer buffer)
    {
        String string = "";
        try
        {
            for(int i = 0; i<buffer.position();i++){
                string += (char)buffer.get(i);
            }
            return string;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ImServer()).start();

        while(true){
            Thread.sleep(3*1000);
        }
    }
}
