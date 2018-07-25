package www.zhidisoft.com.work426.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.zhidisoft.com.work426.verifycode.VerifyCode;

@WebServlet(urlPatterns="/VerifyCodeServlet.do")
@SuppressWarnings("serial")
public class VerifyCodeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VerifyCode code = new VerifyCode();
		BufferedImage image = code.createImage();
		ImageIO.write(image,"jpg",response.getOutputStream());
	}

}
