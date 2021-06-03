package src.reactorNIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Classic ServerSocket Loop
 *
 * 传统的多线程IO,每个线程处理一个请求
 *
 * @Author deng shuo
 * @Date 5/26/21 23:09
 * @Version 1.0
 */
public class ClassicServerModel implements Runnable{

    private static final int PORT = 8085;
    private static final int MAX_INPUT = 1024 *1024;

    @Override
    public void run() {
        try{
            ServerSocket ss = new ServerSocket(PORT);
            while(!Thread.interrupted()){
                new Thread(new Handler(ss.accept())).start();;
            }
        }catch (IOException ex){
            /* Handler exception*/
            ex.printStackTrace();
        }
    }

    static class Handler implements Runnable{
        final Socket socket;

        Handler(Socket s){socket = s;}

        @Override
        public void run() {
            try{
                byte[] input = new byte[MAX_INPUT];
                socket.getInputStream().read(input);

                byte[] output = process(input);
                socket.getOutputStream().write(output);
            }catch (IOException ex){
                /* handler exception*/
            }
        }

        private byte[] process(byte[] cmd){
            /* 处理输入数据  cmd*/

            byte[] output = new byte[MAX_INPUT];
            return  output;
        }
    }
}
