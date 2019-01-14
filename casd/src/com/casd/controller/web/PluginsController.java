package com.casd.controller.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *Java注释内容
 * @version 1.0
 * 生成验证码      2017-10-23
 * @author Mr Liao
 * 
 * */

@Controller
@RequestMapping(value = "/plugins")
	public class PluginsController {              
 
		@RequestMapping("/verifyCode")
		public void verifyCode(HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			// w=100&h=30&k=admin_code"
			String code = request.getParameter("k");

			HttpSession session = request.getSession(true);

			response.setContentType("image/jpeg");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 240);
			int width = 60, height = 22;
			ServletOutputStream out = response.getOutputStream();
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB); // 设置图片大小的

			Graphics gra = image.getGraphics();

			Random random = new Random();

			gra.setColor(getRandColor(200, 250)); // 设置背景色
			gra.fillRect(0, 0, width, height);

			gra.setColor(Color.black); // 设置字体色
			System.setProperty("java.awt.headless", "true");
			gra.setFont(new Font("Times New Roman", Font.PLAIN, 18));

			// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
			gra.setColor(getRandColor(160, 200));

			for (int i = 0; i < 155; i++) {
				int x = random.nextInt(width);
				int y = random.nextInt(height);
				int xl = random.nextInt(12);
				int yl = random.nextInt(12);
				gra.drawLine(x, y, x + xl, y + yl);
			}

			// 取随机产生的认证码(4位数字)
			String sRand = com.casd.Utils.getRandString(4, "0123456789");
			for (int i = 0; i < sRand.length(); i++) {

				char rand = sRand.charAt(i);
				// Thread.sleep(new Random().nextInt(10)+10);//休眠以控制字符的重复问题

				// 将认证码显示到图象中
				gra.setColor(new Color(20 + random.nextInt(110), 20 + random
						.nextInt(110), 20 + random.nextInt(110))); // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成

				gra.drawString("" + rand, 13 * i + 6, 16);
			}

			session.setAttribute(code, sRand);
			ImageIO.write(image, "JPEG", out);
			out.flush();
			out.close();
		}

		private Color getRandColor(int fc, int bc) { // 给定范围获得随机颜色
			Random random = new Random();
			if (fc > 255)
				fc = 255;
			if (bc > 255)
				bc = 255;
			int r = fc + random.nextInt(bc - fc);
			int g = fc + random.nextInt(bc - fc);
			int b = fc + random.nextInt(bc - fc);
			return new Color(r, g, b);
		}

}
