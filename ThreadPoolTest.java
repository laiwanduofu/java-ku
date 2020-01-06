import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        //核心线程数  最大线程数   临时工等待多久  任务保存在阻塞队列中
        //任务满了的处理方法
        //定制化程度最高
        ThreadPoolExecutor executor= new ThreadPoolExecutor(1,
                5,3000,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue(Integer.MAX_VALUE),
                new ThreadPoolExecutor.AbortPolicy());

        //单线程
        ExecutorService single= Executors.newSingleThreadExecutor();
        //固定线程
         ExecutorService fixed=  Executors.newFixedThreadPool(2);
        //可以缓存
         ExecutorService cached=  Executors.newCachedThreadPool();
        //定时范围的线程
         ExecutorService scheduled= Executors.newScheduledThreadPool(3);
    }
}
