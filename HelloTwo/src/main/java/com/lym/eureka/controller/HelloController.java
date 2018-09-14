package com.lym.eureka.controller;

import java.text.MessageFormat;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lym.eureka.entity.User;

@RestController
public class HelloController {
	private final Logger logger=Logger.getLogger(getClass());
	@Autowired
	private DiscoveryClient client;
	@Autowired
	private Registration registration;
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String index() {
		ServiceInstance instance=serviceInstance();
		logger.info(MessageFormat.format("/hello,host:{0},service_id:{1}", instance.getHost(),instance.getServiceId()));
		return "Hello world";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public ResponseEntity<User> userInfo(@QueryParam(value="name")String name) {
		User user=new User();
		user.setUserName(name);
		user.setAge(18);
		user.setSex("girl");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public ResponseEntity<User> user(@RequestBody User user) {
		if (user.getAge()>20) {
			user.setSex("he is a boy");
		}else {
			user.setSex("she is a girl");
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public void userInfo(@RequestBody User user) {
		if (user.getAge()>20) {
			logger.info("she is a girl");
		}else {
			logger.info("he is a boy");
		}
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public void userInfoDelete(@QueryParam(value="name")String name) {
		logger.info(MessageFormat.format("{0} info delete finished", name));
	}
	
	
	
	/**
     * 获取当前服务的服务实例
     *
     * @return ServiceInstance
     */
    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
