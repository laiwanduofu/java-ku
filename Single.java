public class Single {
    // 饿汉模式
    private static  final Single SINGLE=new Single();
    public static Single getInstance(){
        return SINGLE;
    }
    private Single(){
        // nothing to do
    }
    // 懒汉式
   private volatile static  Single SINGLE2=null;
    public   static  Single getInstance2(){
        if(SINGLE2==null){
            synchronized (Single.class){
                if(SINGLE2==null){
                    SINGLE2=new Single();
                }
            }
        }
        return SINGLE2;
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Single.getInstance2();
                }
            }).start();
        }
    }
}
