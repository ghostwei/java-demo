package com.demo.ocr;

import java.io.File;
import java.io.IOException;

/**
 * @author wei
 * Email: ghostwei@gmail.com
 * Project Name: java-demo
 * DateTime: 2022/9/20 15:51
 */
public class Test {

	public static void main(String[] args) {
		String path = "C://temp//OCRcode//4.png";
		System.out.println("ORC Test Begin......");
		try {
			String valCode = new OCR().recognizeText(new File(path), "png");
			System.out.println(valCode);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ORC Test End......");
	}

}
