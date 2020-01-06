public class SequencePrint {
    private static String[] INFOS = {"A", "B", "C","D"};

    private static int INDEX;

    public static void main(String[] args) {
        for (int i = 0; i < INFOS.length; i++) {
            new Thread(new PrintTask(i)).start();
            }
        }
    public static class PrintTask implements Runnable{
        private Integer index;

        public PrintTask(Integer index) {
            this.index = index;
        }

        @Override
        public void run() {
            try {
                for (int j = 0; j < 10; j++) {
                    synchronized (INFOS){
                        while (INDEX!=index){
                            INFOS.wait();
                        }
                        System.out.println(INFOS[index]);
                        if(index==INFOS.length-1){
                            System.out.println("====="+j);
                        }
                        INDEX= (INDEX+1)%INFOS.length;
                        INFOS.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
