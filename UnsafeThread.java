public class UnsafeThread {
    public  static int COUNT;
// 把它变成安全的
    public static void main(String[] args) {
        Object object=new Object();
        for(int i=0;i<20;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<10000;j++){
                       //increment();
                        synchronized (object){
                            COUNT++;
                        }
                    }
                }
            }).start();
            while (Thread.activeCount()>1){
                Thread.yield();
            }
            System.out.println(COUNT);
        }
    }
//   public synchronized static  void increment(){
//        COUNT++;
//   }
    public static void increment(){
        synchronized (UnsafeThread.class){
            COUNT++;
        }
    }
}
