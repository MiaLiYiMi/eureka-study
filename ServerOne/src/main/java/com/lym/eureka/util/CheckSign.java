package com.lym.eureka.util;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Date;

import org.joda.time.DateTime;

import com.alibaba.fastjson.JSONObject;

/**
 * @since
 * @author liym
 *
 */
public class CheckSign {

	// 得到产生的私钥/公钥对
	public static KeyPair getKeypair() {
		// 产生RSA密钥对(myKeyPair)
		KeyPairGenerator myKeyGen = null;
		try {
			myKeyGen = KeyPairGenerator.getInstance("RSA");
			myKeyGen.initialize(1024);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		KeyPair myKeyPair = myKeyGen.generateKeyPair();
		
		return myKeyPair;
	}

	//根据密钥对对信息进行加密，返回公钥值
	public static byte[] getpublicByKeypair(Signature mySig,KeyPair myKeyPair,byte[] infomation){  
        byte[] publicInfo=null;  
        try {             
            mySig.initSign(myKeyPair.getPrivate());  //用私钥初始化签名对象  
            mySig.update(infomation);  //将待签名的数据传送给签名对象 
            publicInfo = mySig.sign();  //返回签名结果字节数组            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return publicInfo;  
    }
	
	//公钥验证签名
	public static boolean decryptBypublic(Signature mySig,  KeyPair myKeyPair,String infomation,byte[] publicInfo){  
        boolean verify=false;  
        try {  
            mySig.initVerify(myKeyPair.getPublic());  //使用公钥初始化签名对象,用于验证签名  
            mySig.update(infomation.getBytes()); //更新签名内容  
            verify= mySig.verify(publicInfo); //得到验证结果  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return verify;  
    }  
	
	private static void getYesterdayTime() {
		Date dateTime = DateTime.now().minusDays(1).toDate();
		System.out.println(dateTime);
	}
	
	private static void doSplit() {
		JSONObject object = new JSONObject();
		object.put("msg", "hi morning");
		object.put("success", true);
		System.out.println(object.toJSONString());
		System.out.println(object.toString());
		
		String str="ABC";
		String[] elems=str.split("");
		System.out.println(Arrays.toString(elems));
	}
	
	public static void main(String[] args) throws SignatureException {
		getYesterdayTime();
		doSplit();
		
		JSONObject object = new JSONObject();
		object.put("msg", "hi morning");
		object.put("success", true);
		System.out.println(object.toJSONString());
		System.out.println(object.toString());
		
		try {             
            KeyPair keyPair=getKeypair();  
            System.out.println("私钥："+keyPair.getPrivate());
    		System.out.println("公钥："+keyPair.getPublic());
            Signature mySig = Signature.getInstance("MD5WithRSA");//用指定算法产生签名对象  

            byte[] publicinfo=getpublicByKeypair(mySig,keyPair,"lym".getBytes());  
            boolean verify=decryptBypublic(mySig, keyPair, "lym", publicinfo);  
            System.out.println("验证签名的结果是："+verify);  
        } catch (NoSuchAlgorithmException e) {  
           e.printStackTrace();  
        }    
	}

}
