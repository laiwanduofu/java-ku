public class Notify {
    private static volatile int COUNT;

    public static void main(String[] args) {
        for(int i=0;i<3;i++){    //生产者
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for(int j=0;j<10;j++){
                            synchronized (Notify.class){
                                while(COUNT+3>100){
                                    //当前线程释放锁，阻塞并等待其他线程调用
                                    Notify.class.wait();
                                }
                                produce();
                                System.out.println(Thread.currentThread().getName()
                                +"生产，当前库存总量"+COUNT);
                                Thread.sleep(500);
                                //唤醒
                                Notify.class.notifyAll();
                            }
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        for(int i=0;i<10;i++){      //消费者
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(true){
                            synchronized (Notify.class){
                                while ( COUNT==0){
                                    //为了在被唤醒后因存量更改，而再次判断是否满足条件
                                    Notify.class.wait();
                                }
                                consume();
                                System.out.println(Thread.currentThread().getName()
                                        +"消费，当前库存总量"+COUNT);
                                Notify.class.notifyAll();
                                Thread.sleep(1000);
                            }
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public synchronized static void produce(){

        COUNT+=3;
    }
    public synchronized static void consume(){
        COUNT--;
    }
}
