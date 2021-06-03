package src.reactorNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author deng shuo
 * @Date 5/27/21 21:24
 * @Version 1.0
 */
public class NIOReactor implements Runnable {
    final Selector selector;
    final ServerSocketChannel serverSocketChannel;

    NIOReactor(int port) throws IOException {
        //1.获取Selector选择器
        selector = Selector.open();
        //2.获取通道
        serverSocketChannel = ServerSocketChannel.open();
        //3.绑定连接
        serverSocketChannel.socket().bind(new InetSocketAddress(port));

        // nonblocking
        serverSocketChannel.configureBlocking(false);
        // register 注册accept事件
        // 4.将通道注册到选择器上
        SelectionKey selectionKey = serverSocketChannel.register(selector,
                                                        SelectionKey.OP_ACCEPT);
        // callback object
        // An attached object may later be retrieved via the attachment() method.
        selectionKey.attach(new Acceptor());

    }

    @Override
    public void run() {
        try{
            while(!Thread.interrupted()){
                selector.select();
                //5.获取当前选择器中所有注册的选择键
                Set<SelectionKey> selected = selector.selectedKeys();
                Iterator iterator = selected.iterator();
                while(iterator.hasNext()){
                    // dispatch分发事件
                    dispatch((SelectionKey)iterator.next());
                }
                selected.clear();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void dispatch(SelectionKey selectionKey){
        //调用SelectionKey绑定的调用对象
        Runnable r =  (Runnable)(selectionKey.attachment());
        //调用之前注册的callback对象
        if(r != null){
            r.run();
        }
    }

    class Acceptor implements Runnable{

        @Override
        public void run() {
            try{

                SocketChannel socketChannel = serverSocketChannel.accept();
                if(socketChannel != null){
                    new NIOHandler(selector,socketChannel);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
