package video.note.tcpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDemo1 {
	public static void main(String[] args) throws IOException {
		//创建一个对象
		//可以指定一个监听的端口号，也可以默认一个构造方法(随机分配端口号)
		DatagramSocket socket = new DatagramSocket();
		String str = "i love you!";
		
		//将数据进行封装(封装到数据报包中
		//发送过去的数据，以字节数组的方式发送，字符串转换成字节数组
		//发送的数据的长度
		//发送给哪台主机，根据主机名得到IP地址
		//目标(接收端)主机所对应的端口号
		DatagramPacket packet = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("localhost"), 8600);
		//发送
		socket.send(packet);
		//接收其他端所传过来的数据包
		byte[] buff = new byte[100];
		DatagramPacket packet2 = new DatagramPacket(buff, 100);  //数据包的最终数据放到buff里，长度100
		//接收传过来的数据包
		socket.receive(packet2);
		
		//System.out.println(new String(packet2.getData()));
		System.out.println(new String(buff, 0, packet.getLength()));
		
		socket.close();
		
	}
}
