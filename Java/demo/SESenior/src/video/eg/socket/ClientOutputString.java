package video.eg.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientOutputString implements Runnable {
	//通过socket对象获得对应的输入输出流
	private Socket socket = null;  //声明一个socket的引用变量
	
	//构造方法
	public ClientOutputString(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			//键盘标准输入流
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			//通过socket对象写入
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
				
			//获得键盘输入的内容
			while(true){
				//获得键盘所输入的一行字符串
				String line = br.readLine();
				pw.println(line);
				if(line.equals(" bye")){
					break;
				}
			}
			
			//释放资源
			br.close();
			pw.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
