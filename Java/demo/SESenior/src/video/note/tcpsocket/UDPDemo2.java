package video.note.tcpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPDemo2 {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(8600);
		
		byte[] buff = new byte[100];
		DatagramPacket packet = new DatagramPacket(buff, 100);
		
		socket.receive(packet);  //接收传来的数据包
		
		//System.out.println(new String(packet.getData()));
		//从buff字节数组中读取，从第0个开始读到第length个
		System.out.println(new String(buff, 0, packet.getLength()));
		
		//发送
		String str = "Me too!";
		DatagramPacket packet2 = new DatagramPacket(str.getBytes(), str.length(), packet.getAddress(), packet.getPort());
		
		//发送
		socket.send(packet2);
		socket.close();
	}
}
