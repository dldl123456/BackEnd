package www.zhidisoft.com.work426.verifycode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class test {
	public static void main(String[] args) throws IOException {
		VerifyCode code = new VerifyCode();
		BufferedImage image = code.createImage();
		ImageIO.write(image,"jpg",new File("F:/image.jpg"));
	}
}
