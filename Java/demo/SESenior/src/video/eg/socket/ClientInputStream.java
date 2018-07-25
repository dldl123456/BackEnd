package video.eg.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ClientInputStream implements Runnable {
	private Socket socket = null;
	
	
	public ClientInputStream(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			//获取服务端传过来的大写字符串
			//socket.getInputStream()获得对应的输入流
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true){
				try {
					//读取
					String line = br.readLine();
					System.out.println(line);
				} catch (SocketException e) {
					break;
				}
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
