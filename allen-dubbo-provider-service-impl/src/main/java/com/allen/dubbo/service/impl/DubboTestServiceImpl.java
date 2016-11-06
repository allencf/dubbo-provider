package com.allen.dubbo.service.impl;

import org.springframework.stereotype.Service;

import com.allen.dubbo.service.DubboTestService;

@Service
/*@com.alibaba.dubbo.config.annotation.Service(version = "1.0.0")*/
public class DubboTestServiceImpl implements DubboTestService {

	public String sayHello() {
		
		return "Hello World !!!";
	}

}
