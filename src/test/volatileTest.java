package src.test;

/**
 * @Author deng shuo
 * @Date 3/20/21 21:19
 * @Version 1.0
 */
public class volatileTest {

    public static void main(String[] args) {
        VThread  vThread = new VThread();

        vThread.start();

        for(; ; ){
            if(vThread.isFlag()){
                System.out.println("flag changed");
            }
        }
    }

}

class VThread extends Thread{
    // volatile
    private  boolean flag = false;

    public boolean isFlag(){
        return flag;
    }

    @Override
    public void run(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + flag);
    }
}

