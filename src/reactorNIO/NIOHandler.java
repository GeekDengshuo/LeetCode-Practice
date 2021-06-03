package src.reactorNIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @Author deng shuo
 * @Date 5/27/21 21:40
 * @Version 1.0
 */
public final class NIOHandler implements Runnable {

    private static final int MAX_IN = 1024 *1024 ;
    private static final int MAX_OUT = 1024 *1024;
    final SocketChannel socketChannel;
    final SelectionKey selectionKey;

    ByteBuffer input = ByteBuffer.allocate(MAX_IN);
    ByteBuffer output = ByteBuffer.allocate(MAX_OUT);
    static final int READING = 0, SENDING = 1;
    int state = READING;

    NIOHandler(Selector s,SocketChannel c) throws IOException {
        socketChannel = c;
        socketChannel.configureBlocking(false);

        selectionKey = socketChannel.register(s,0);
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        s.wakeup();


    }

    @Override
    public void run() {
        try{
            if(state == READING){
                read();
            }else if(state == SENDING){
                send();
            }
        }catch (IOException ie){
            ie.printStackTrace();
        }
    }

    void read() throws IOException {
        socketChannel.read(input);
        if (inputIsComplete()) {
            process();
            state = SENDING;
            // Normally also do first write now
            selectionKey.interestOps(SelectionKey.OP_WRITE);
        } }
    void send() throws IOException {
        socketChannel.write(output);
        if (outputIsComplete())
            selectionKey.cancel();
    }

    boolean inputIsComplete() { /* ... */ return true;}
    boolean outputIsComplete() { /* ... */return true;}
    void process() { /* ... */ }
}
