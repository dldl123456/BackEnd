package video.eg.Swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class NotePadDemo {
	public static void main(String[] args) {
		new MyFrame("记事本");
	}
}

@SuppressWarnings("serial")
class MyFrame extends JFrame{
	//多行文本框
	private JTextArea tv_area = null;
	
	public MyFrame(String title){
		super(title);
		init();
		registerListener();
	}
	
	//初始化相关的组件
	private void init(){
		tv_area = new JTextArea();
		Container cpane = this.getContentPane();
		cpane.add(tv_area, BorderLayout.CENTER);
		this.setSize(500, 300);  //设置窗体大小
		
		//关闭窗口的时候退出应用程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口居中显示
		//定义一个工具包
		Toolkit kit = Toolkit.getDefaultToolkit();
		//获得屏幕的宽度和高度
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;  //获得屏幕的宽度
		int screenHeight = screenSize.height;  //获得屏幕的高度
		
		int windowWidth = this.getWidth();  //获得当前窗体的宽度
		int windowHeight = this.getHeight();  //获得当前窗体的高度
		
		this.setLocation((screenWidth-windowWidth)/2, (screenHeight-windowHeight)/2);
		
		this.setVisible(true);  //显示窗体
	}
	
	//给相关的组件(控件)设置事件监听器
	public void registerListener(){
		
	}
}