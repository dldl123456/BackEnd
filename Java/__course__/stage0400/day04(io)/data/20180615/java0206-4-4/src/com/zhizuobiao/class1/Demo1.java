package com.zhizuobiao.class1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * ת����
 */
public class Demo1 {

	public static void main(String[] args) throws Exception {

		// �ֽ��� --> �ַ���
		File file = new File("");
		FileInputStream fis = new FileInputStream(file);

		Reader reader = new InputStreamReader(fis, "utf-8");

		FileOutputStream fos = new FileOutputStream(file);

		Writer writer = new OutputStreamWriter(fos, "utf-8");
	}
}
