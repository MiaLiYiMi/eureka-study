package com.lym.eureka.util;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OrcImageCodeUtil {

	public static void main(String[] args) {
		File imageFile = new File("E:/test1.jpg");  
        Tesseract instance = new Tesseract();

        //将验证码图片的内容识别为字符串 
        try {
			String result = instance.doOCR(imageFile);
			System.out.println(result);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
