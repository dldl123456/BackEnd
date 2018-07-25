package video.eg.MutiCopyFileDemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MutiCopyFileDemo {
	public static void main(String[] args) {
		MutiCopyFileUtil copyFileUtil = new MutiCopyFileUtil("D:\\_site_\\aaa\\aa.mp3", "D:\\_site_\\aac\\cc.mp3", 3);
		
		copyFileUtil.copyFile();
	}
}

class MutiCopyFileUtil{
	private String src;  //源文件
	private String dst;  //目标文件
	private int threadSize;  //开启多个线程去复制源文件
	
	//构造方法
	public MutiCopyFileUtil(String src, String dst, int threadSize) {
		super();
		this.src = src;
		this.dst = dst;
		this.threadSize = threadSize;
	}
	
	//拷贝文件的方法
	public void copyFile(){
		File file = new File(src);  //源文件的File对象
		long fsize = file.length();  //得到要赋值文件的大小(字节数)
		
		//每个线程下载的文件块的大小(字节数)
		long block = fsize%threadSize==0 ? fsize/threadSize : fsize/threadSize+1;
		
		for(int threadId=0; threadId<threadSize; threadId++){
			//开启多个线程来进行文件的复制，每个线程都会复制一段区域
			new DownLoadThread(fsize, block, threadId).start();
		}
	}
	
	//成员内部类(线程类)
	private class DownLoadThread extends Thread{
		private long fsize;  //文件大小
		private long block;  //每个线程要下载的字节数大小
		private int threadId;  //线程Id号，从0开始
		private int bufSize = 1024*1024;  //缓冲区大小(1M)
		
		//构造方法
		public DownLoadThread(long fsize, long block, int threadId) {
			super();
			this.fsize = fsize;
			this.block = block;
			this.threadId = threadId;
		}
		
		//线程操作
		@Override
		public void run() {
			try {
				//每个线程都要读源文件
				RandomAccessFile reader = new RandomAccessFile(src, "r");  //只读
				//每个线程都要写入目标文件
				RandomAccessFile writer = new RandomAccessFile(dst, "rw");  //读写
				//每个线程下载的起始位置
				long startPosition = threadId*block;
				//每个线程下载的结束位置
				long endPosition = startPosition+block>fsize ? fsize : startPosition+block;
				//每个线程都指向源文件所对应的起始下载的位置(文件指针)
				reader.seek(startPosition);
				//每个线程都指向目标文件所对应的起始写入的位置(文件指针)
				writer.seek(startPosition);
				//缓冲区
				byte[] buff = new byte[bufSize];
				
				//下载
				while(startPosition<endPosition){
					int len = 0;  //读到的实际长度
					if(startPosition+bufSize<endPosition){
						len = reader.read(buff);  //读满缓冲区
					}else{
						//把剩余的填不满缓冲区的数据写入到缓冲区中
						len = reader.read(buff, 0, (int)(endPosition-startPosition));
					}
					startPosition += len;  //起始位置读一次就发生变化
					writer.write(buff, 0, len);  //把缓冲区中的数据写入指定文件的指定区域
					
					System.out.println("线程：" + (threadId+1) + "下载" + len + "字节");
				}
				
				//释放资源
				reader.close();
				writer.close();
				System.out.println("线程：" + (threadId+1) + "下载完毕");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

