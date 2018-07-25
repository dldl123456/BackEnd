package com.zhizuobiao.class1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

/**
 * url
 */
public class Demo3 {

	public static void main(String[] args) throws Exception {

		test2();
	}

	public static void test2() throws Exception {
		URL url = new URL("https://d1.music.126.net/dmusic/cloudmusicsetup_2.4.0.196505.exe");

		URLConnection conn = url.openConnection();

		InputStream ins = conn.getInputStream();

		FileOutputStream fos = new FileOutputStream(new File("D:\\1_java\\a\\cloudmusic.exe"));

		byte[] buff = new byte[1024];

		int len = 0;
		while ((len = ins.read(buff)) != -1) {
			fos.write(buff, 0, len);
		}

		fos.close();
		ins.close();
	}

	public static void test1() throws Exception {
		URL url = new URL("http://www.baidu.com");

		URLConnection conn = url.openConnection();

		InputStream ins = conn.getInputStream();

		Reader reader = new InputStreamReader(ins, "utf-8");

		BufferedReader buffReader = new BufferedReader(reader);

		String line = null;

		while ((line = buffReader.readLine()) != null) {
			System.out.println(line);
		}

		buffReader.close();
		reader.close();
		ins.close();
	}
}
