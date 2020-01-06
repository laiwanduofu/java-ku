import java.io.File;

public class FileOperator {
    private volatile File file;
    public  void read(){
        //String=file.read
    }
    public synchronized void write(){
        //file.write(String)
    }
}
