public class MyTimer {

    public void schedule(Runnable task,long delay,long period){
        new Thread(new MyTimerTask(task,delay,period)).start();

    }

    public static class MyTimerTask implements Runnable{

        private  long delay;
        private  Runnable task;
        private  long period;
        private long next;
        public MyTimerTask(Runnable task, long delay, long period) {
            this.task=task;
            this.next=System.currentTimeMillis()+delay;
            this.period=period;
        }

        @Override
        public void run() {
            while (true){
                long current=System.currentTimeMillis();
                if(current>next){  // 当前时间大于下次执行时间就执行
                    task.run();
                    if(period>0){     //时间间隔大于0需要重复执行
                        next+=period;
                    }else {
                        break;
                    }
                }
                try {
                    Thread.sleep(next-current);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main(String[] args) {
        MyTimer timer=new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("myTime");
            }
        },0,1000);
    }
}
