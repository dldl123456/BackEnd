package video.note.url;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
/*import java.net.URLConnection;*/

public class URLDemo {
	public static void main(String[] args) {
		try {
			DownLoadUtil.download("https://www.baidu.com/img/bd_logo1.png", "my.jpg", "d:\\_____");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

//工具类
class DownLoadUtil{
	//让调用这个方法的人捕获异常
	public static void download(String urlString, String fileName, String savePath) throws IOException{
		//创建url对象
		URL url = new URL(urlString);
		//和网络资源建立连接
		/*URLConnection conn = url.openConnection();*/
		//因为要下载，所以要获得它的(网络资源)输入流
		/*InputStream is = conn.getInputStream();*/
		
		//替换成一条语句(先建立连接并返回一个字节输入流)
		InputStream is = url.openStream();
		
		//下载
		//准备一个缓冲区
		byte[] buff = new byte[1024];
		//实际读到的长度
		int len = 0;
		//创建一个目录
		File file = new File(savePath);
		//判断目录是否存在
		if(!file.exists()){
			//不存在就创建一个目录
			file.mkdirs();
		}
		//下载(写)
		FileOutputStream os = new FileOutputStream(file.getAbsolutePath() + "\\" + fileName);
		//读到缓冲区
		while((len=is.read(buff))!=-1){
			//把缓冲区中的数据写到对应的输出流中去(指定目录的指定文件名)
			os.write(buff, 0, len);
		}
		//释放资源
		os.close();
		is.close();
		
		System.out.println("图片下载成功！");
	}
}
