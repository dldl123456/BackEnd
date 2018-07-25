package video.eg.socket;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 8888);
		
		//向服务端写
		//开启2个线程
		new Thread(new ClientInputStream(socket)).start();  //输入流
		new Thread(new ClientOutputString(socket)).start();  //输出流
	}
}
