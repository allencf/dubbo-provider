package com.allen.dubbo.service.impl;

import org.springframework.stereotype.Service;

import com.allen.dubbo.service.DubboTestService;

@Service
public class DubboTestServiceImpl implements DubboTestService {

	public String sayHello() {
		
		return "Hello World !!!";
	}

}
