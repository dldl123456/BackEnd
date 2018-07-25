package video.note.tcpsocket;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		//1、创建一个SeverSocket对象
		ServerSocket severSocket = new ServerSocket(8888);
		//2、调用accept()方法接收客户端请求
		Socket socket = severSocket.accept();
		
		System.out.println(socket.getInetAddress().getHostAddress() + " has connected");
		
		//3、获取socket对象的输入输出流(字节流转字符流)
		//字节输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//字节输出流
		/*BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));*/
		
		//另一种方法不用缓冲区
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);  //true表示自动刷新
		
		//读客户端写过来的字符串,
		String line = null;
		//一直读取客户端写过来的字符串(数据)
		while((line=br.readLine()) != null){
			if(line.equals("over")){
				break;
			}
			System.out.println(line);
			/*//把转换成大写的字符串传给客户端
			bw.write(line.toUpperCase());
			bw.newLine();
			//清空缓冲区
			bw.flush();*/
			
			pw.println(line.toUpperCase());
		}
		
		//释放资源
		/*bw.close();*/
		br.close();
		socket.close();
		pw.close();
		
		System.out.println(socket.getLocalAddress().getHostName() + " has disconnected");
	}
}
