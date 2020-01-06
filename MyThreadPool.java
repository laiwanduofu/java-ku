public class MyThreadPool {
    private Thread[]threads;
    private MyBlockingQueue<Runnable>workQueue;



    public MyThreadPool(int capacity, int size){
        //给固定大小的容量，初始化线程数组
        threads=new Thread[capacity];
        workQueue=new MyBlockingQueue<>(size);
        //初始化每个线程，并直接运行
        for(int i=0;i<capacity;i++){
            threads[i]=new MyThread(workQueue);
            threads[i].start();
        }
    }
    // 提供其他地方使用，传入需要执行的任务
    public void execute(Runnable task){
        workQueue.put(task);
    }
    //扩展
    public static class MyThread extends Thread{
        private MyBlockingQueue<Runnable>workQueue;
        public MyThread(MyBlockingQueue<Runnable> workQueue) {
            this.workQueue=workQueue;
        }

        @Override
        public void run() {
            //自己的逻辑
            //不停的从阻塞队列中取任务，取到了就执行，取不到就等待
            while (true){
                try {
                    Runnable task=workQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
       MyThreadPool pool= new MyThreadPool(5,100);
       Runnable task=new Runnable() {
           @Override
           public void run() {
               System.out.println("task");
           }
       };
       for(int i=0;i<10;i++){
           new Thread(new Runnable() {
               @Override
               public void run() {
                   pool.execute(task);
               }
           }).start();
       }
    }
}
