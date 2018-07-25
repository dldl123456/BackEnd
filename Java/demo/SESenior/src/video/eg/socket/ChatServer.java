package video.eg.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException {
		//接收客户端所传过来的socket对象
		ServerSocket severSocket = new ServerSocket(8888);
		
		//保存客户端的个数
		int number = 1;
		
		while(true){
			//接收客户端传过来的请求，返回的是socket对象
			Socket socket = severSocket.accept();
			
			System.out.println("客户端" + number + "连接成功！");
			
			//创建线程对客户端进行读写操作
			//服务端开启一个独立的线程对客户端进行读写操作
			new Thread(new ServerStream(socket, number)).start();
			
			number++;
		}
		
		
	}
}
