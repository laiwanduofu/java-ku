
public class MyBlockingQueue<E> {

    private Object[]elements;
    //当前可以保存元素的索引
    private int putIndex;
    //当前可以获取元素的索引
    private int takeIndex;
    //当前的长度
    private int size;

    public MyBlockingQueue(int capacity){
        elements=new Object[capacity];
    }
    public synchronized void  put(E element){
        try {
            while (size==elements.length){
                wait();
            }
            elements[putIndex]=element;
            putIndex=(putIndex+1)%elements.length;
            size++;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized E take() throws InterruptedException {
        while(size==0){
            wait();
        }
        E element=(E)elements[takeIndex];
        takeIndex=(takeIndex+1)%elements.length;
        size--;
        notifyAll();
        return element;
    }

    public static void main(String[] args) {
        MyBlockingQueue<String>queue=new MyBlockingQueue<>(20);
        for(int i=0;i<10;i++){
            final int k=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<20;j++){
                        queue.put(String.valueOf(k+","+j));
                    }
                }
            }).start();
        }

        for(int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String e=queue.take();
                        System.out.println(e);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
