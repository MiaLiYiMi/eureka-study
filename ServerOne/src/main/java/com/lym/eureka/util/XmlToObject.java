package com.lym.eureka.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lym.eureka.entity.MessageBody;


public class XmlToObject {
	
	private final static Logger LOGGER=LoggerFactory.getLogger(XmlToObject.class);

	public static void main(String[] args) throws JAXBException, IOException {
		String xmlPath =  "E:\\123.xml";
		File file=new File(xmlPath);
		if(file.exists()) {
			LOGGER.info("-....-");
		}
		Object object = XmlToObject.xmlToBean(xmlPath,MessageBody.class);
		MessageBody body =(MessageBody) object;
		LOGGER.info(body.toString());
		
		System.out.println(xml2jsonString());
	}
	
	public static Object xmlToBean(String xmlPath,Class<?> load) throws JAXBException, IOException{
		JAXBContext context = JAXBContext.newInstance(load);  
		Unmarshaller unmarshaller = context.createUnmarshaller(); 
		Object object = unmarshaller.unmarshal(new File(xmlPath));
		return object;
		}
	
	public static String xml2jsonString() throws JSONException, IOException {
		System.out.println(">>>>>>>");
		String xmlPath =  "E:\\eacqry.AcBalQry.xml";
		File file=new File(xmlPath);
		FileInputStream fileInputStream=new FileInputStream(file);
        String xml = IOUtils.toString(fileInputStream);
        System.out.println(xml);
        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        return xmlJSONObj.toString();
    }


}
