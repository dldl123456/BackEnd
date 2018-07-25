package video.eg.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerStream implements Runnable {
	//通过IO对客户端读写操作
	private Socket socket = null;
	private int number;
	
	//生成带2个参数的构造方法
	public ServerStream(Socket socket, int number) {
		super();
		this.socket = socket;
		this.number = number;
	}

	@Override
	public void run() {
		//获取客户端传过来的字符串(通过IO中的输入流)
		//字符流(字节流转字符流)
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//写(得到对应的字节输出流，并自动刷新缓冲区)
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			//只要客户端发过来就能一直读
			while(true){
				String line = br.readLine();  //读到客户端传过来的字符串
				System.out.println("客户端" + number + ":" + line);
				pw.println(line.toUpperCase());
				if(line.equals("bye")){
					System.out.println("客户端" + number + "已经断开连接");
					break;
				}
			}
			br.close();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
