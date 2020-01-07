import org.junit.Test;

import java.io.*;

public class TEST {

    @Test
    public void Test1() throws FileNotFoundException {
      // 字节流
        FileInputStream fis=null;
        try {
            try {
                File file=new
                        File("D:\\code.py\\abc.txt");
                fis=new FileInputStream(file);
                byte[]bytes=new byte[1024];
                int size;
                while((size=fis.read())!=-1){
                    System.out.println(new String(bytes,0,size));
                }
            } finally {
                if(fis!=null){
                    fis.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void test2() throws UnsupportedEncodingException {
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        try {
            try {
                is=TEST.class.getClassLoader().getResourceAsStream
                        ("D:\\code.py\\abc.txt");
                isr=new InputStreamReader(is,"UTF-8");
                br=new BufferedReader(isr);
                String line;
                while((line=br.readLine())!=null){
                    System.out.println(line);
                }
            } finally {
                if(br!=null){
                    br.close();
                }if(isr!=null){
                    isr.close();
                }if(is!=null){
                    is.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test3() throws IOException {
        File file=new File("D:\\code.py\\abc.txt");
        BufferedWriter writer=new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file),
                        "UTF-8"));
        writer.write("hello");
        writer.newLine();
        writer.write("hah");
        writer.flush();
    }

}
