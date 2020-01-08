package udp.echo;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.DatagramSocketImpl;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Server {
    private static Map<String,String>dictionary=new HashMap<>();
    static {
        try {
            InputStream is=new FileInputStream("字典.txt");
            Scanner scanner=new Scanner(is,"UTF-8");
            while (scanner.hasNext()){
                String line=scanner.nextLine();
                String[]kv=line.split(":");
                dictionary.put(kv[0],kv[1]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static String translate(String eng){
        return dictionary.getOrDefault(eng,"不知道");
    }
    public static void main(String[] args) throws IOException {
        //创建服务器SOCKET,同时还绑定了6666端口，默认绑定的IP是所有IP
        DatagramSocket socket = new DatagramSocket(6666);  // 开店
        while (true) {
            byte[] buffer = new byte[4096];// 准备一个接受缓冲区
            //创建了一个接受报文
            DatagramPacket receivePacket = new DatagramPacket
                    (buffer, 0, buffer.length);
            //当receive返回时，os就会把接受过来的数据填充到缓冲区
            socket.receive(receivePacket);
        //获取实际收到的数据长度
            int len = receivePacket.getLength();
            //把字节转化字符
            String message = new String(buffer, 0, len, "UTF-8");
            System.out.println(message+"收到了");
           //准备回给对方消息
            String echoMessage = translate(message);
            //字符转字节
            byte[] sendBuffer = echoMessage.getBytes("UTF-8");
            //创建发送报文
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
                    0, sendBuffer.length, receivePacket.getAddress(),
                    receivePacket.getPort());
            //发送，发送成功只是代表发送到了网络上
            socket.send(sendPacket);
        }
        //socket.close();
    }
}
