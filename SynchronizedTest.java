public class SynchronizedTest {
    public synchronized static void method1(){
        System.out.println(Thread.currentThread().getName()+"第一个");
        while (true){

        }
    }
    public synchronized static void method2(){
        System.out.println(Thread.currentThread().getName()+"第二个");
        while (true){

        }
    }

    public static void main(String[] args) {
        MyObject object=new MyObject();
        MyObject object1=new MyObject();
       new Thread(new Runnable() {
           @Override
           public void run() {
              //object1.method4();
               synchronized (object1){
                   System.out.println(Thread.currentThread().getName() + "第四个");
                   while (true) {

                   }
               }
           }
       }).start();
       new Thread(new Runnable() {
           @Override
           public void run() {
              object. method3();
           }
       }).start();
    }
}
class MyObject{
    public synchronized  void method3(){
        System.out.println(Thread.currentThread().getName()+"第三个");
        while (true){

        }
    }
    public synchronized void method4() {
        System.out.println(Thread.currentThread().getName() + "第四个");
        while (true) {

        }
    }
}