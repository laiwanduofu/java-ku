import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class MyTimerPool {
    private PriorityBlockingQueue<MyTimerTask> workQueue;
    private MyTimerThread[]threads;


    public MyTimerPool(int capacity,int size){
        this.threads= new  MyTimerThread[capacity];
        workQueue=new PriorityBlockingQueue<>(size);
        for(int i=0;i<capacity;i++){
            threads[i]=new MyTimerThread(workQueue);
            threads[i].start();
        }
    }

    public void schedule(Runnable task,long delay,long period){

        workQueue.put(new MyTimerTask(task,period,delay));
        synchronized (workQueue){
            workQueue.notifyAll();
        }
    }
    public static class MyTimerThread extends Thread{
        private PriorityBlockingQueue<MyTimerTask> workQueue;
        public MyTimerThread(PriorityBlockingQueue<MyTimerTask> workQueue) {
            this.workQueue=workQueue;
        }

        @Override
        public void run() {
            while (true){
                try {
                     MyTimerTask MyTimerTask= workQueue.take();
                     long current=System.currentTimeMillis();
                     long next=MyTimerTask.next;
                     if(current<next){
                         synchronized (workQueue){
                             workQueue.wait(next-current);
                             workQueue.put(MyTimerTask);
                             continue;
                         }

                     }
                     else{
                         MyTimerTask.task.run();
                         if(MyTimerTask.period>0){
                             MyTimerTask.next+=MyTimerTask.period;
                             workQueue.put(MyTimerTask);
                         }
                     }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class MyTimerTask implements Comparable<MyTimerTask> {
        private  Runnable task;
        private  long period;
        private long next;

        public MyTimerTask(Runnable task, long period, long delay) {
            this.task = task;
            this.period = period;
            this.next = System.currentTimeMillis()+delay;
        }

        @Override
        public int compareTo(MyTimerTask o) {
            return Long.compare(next,o.next);
        }
    }

    public static void main(String[] args) {
        MyTimerPool pool=new MyTimerPool(3,1000);
        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("明天要答辩");
            }
        },0,3000);
        pool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("后天");
            }
        },1000,2000);
        // List<person>list   Queue<person>queue
//        Collections.sort(list, new Comparator<person>() {
//            @Override
//            public int compare(person o1, person o2) {
//                return 0;
//            }
//        });
//        Arrays.sort(list);//person类实现compare接口

    }
}
