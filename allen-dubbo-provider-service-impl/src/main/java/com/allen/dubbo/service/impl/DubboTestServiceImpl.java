package com.allen.dubbo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.allen.dubbo.service.DubboTestService;

@Service
/*@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0")*/
public class DubboTestServiceImpl implements DubboTestService {

	private final static Logger logger = LoggerFactory.getLogger(DubboTestServiceImpl.class);
	
	public String sayHello() {
		logger.info("dubboTestService  -----------------------------");
		return "Hello World !!!";
	}
	
	public static void main(String[] args) {
		logger.info("test-------------");
		
	}

}
