public class StopThread {
    public static void main(String[] args) throws InterruptedException {
       Thread thread1=new Thread(new Runnable() {
            @Override
          public void run() {
                try {
                  //调用sleep(),wait(),join(),方式时，线程进入阻塞状态
                 //进入阻塞状态后，此时也可以中断，中断后抛出InterruptedException
                    //标志位会变成false;
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
           }
        });
        thread1.start();
          Thread.sleep(1000);
          //优势在于可以中断阻塞线程
        thread1.interrupt();

//        Thread thread2=new Thread(new Runnable() {
//            @Override
//            public void run() {
//               for(int i=0;i<10;i++){
//                   //boolean tmp=标志位 ，标志位=false; return tmp;
//                   //重置标志位为false,并返回之前的标志位;
//                   boolean b=Thread.interrupted();
//                   //获取当前的标志位
//                  // boolean b=Thread.currentThread().isInterrupted();
//                   System.out.println(b);
//               }
//            }
//        });
//        thread2.start();
//        thread2.interrupt();//修改标志位=true
    }
}
