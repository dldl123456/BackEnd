package video.note.tcpsocket;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 8888);
		//获取键盘输入流(用缓冲区)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//输出流，通过socket来获得socket套接字对象，获得字节输出流(用缓冲区)
		/*BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));*/
		//获取服务器端输入流
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//另一种方法不用缓冲区
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);  //true表示自动刷新
		
		//死循环，可以不断地向服务端发送字符串
		while(true){
			String line = br.readLine();  //获取键盘所输入的字符串
			//写
			/*bw.write(line);
			bw.newLine();  // 换行
			bw.flush();*/
			pw.println(line);
			if(line.equals("over")){
				break;
			}
			//读取服务端的大写字符串
			System.out.println(reader.readLine());
		}
		
		//释放资源
		reader.close();
		br.close();
		/*bw.close();*/
		pw.close();
		socket.close();
	}
}
