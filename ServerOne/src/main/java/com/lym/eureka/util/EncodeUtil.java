package com.lym.eureka.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.ClientProtocolException;

public class EncodeUtil {

	@SuppressWarnings("deprecation")
	private static void encodeDeal(String url) {

		url = URLEncoder.encode(url);
		System.out.println(url);
		url = URLDecoder.decode(url);
		System.out.println(url);
	}

	// md5编码
	public static String getMd5(String newString) throws UnsupportedEncodingException {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		byte[] btInput = newString.getBytes("UTF-8");
		char str[] = null;
		try {
			// 获得MD5摘要算法的MessageDigest对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int length = md.length;
			str = new char[length * 2];
			int k = 0;
			for (int i = 0; i < length; i++) {
				byte byte0 = md[i];
				// 取出这个字节的高四位，然后与0x0f与运算，得到一个0-15之间的数据，通过hexDigits（0-15）即为十六进制数
				str[k++] = hexDigits[(byte0 >>> 4) & 0x0f];
				// 取出这个字节的地位，与0x0f与运算，得到一个0-15之间的数据，通过hexDigits（0-15）即为十六进制数
				str[k++] = hexDigits[byte0 & 0x0f];
			}
		} catch (NoSuchAlgorithmException e) {
		}
		return new String(str);
	}

	/**
	 * 将16进制字符串转成byte型
	 * 
	 * @param hexString
	 *            需要转化的字符串
	 * @return
	 */
	public static byte[] toByteArray(String hexString) {
		if (hexString == null)
			throw new IllegalArgumentException("this hexString must not be empty");
		hexString = hexString.toLowerCase();
		final byte[] byteArray = new byte[hexString.length() / 2];
		int k = 0;
		for (int i = 0; i < byteArray.length; i++) {// 因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
			byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
			byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
			byteArray[i] = (byte) (high << 4 | low);
			k += 2;
		}
		return byteArray;
	}

	public static String base64Encode(String md5String) {// Base64编码
		byte[] byteArray = toByteArray(md5String);
		if (byteArray == null) {
			return null;
		} else {
			String sign = new String((new Base64()).encode(byteArray));
			return sign;
		}
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "http://SomeUser:mypassword@www.some_server.com:8080/pathabc/file.html";
		encodeDeal(url);
		String value = "oF3N35KWFfxtgCVOJfpq-7llF7jI";
		System.out.println(">>>>>>>>" + getMd5(value));
		System.out.println(">>>>>>>>" + base64Encode(value));
	}
}
