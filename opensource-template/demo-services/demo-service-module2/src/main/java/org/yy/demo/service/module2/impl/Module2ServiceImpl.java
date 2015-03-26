package org.yy.demo.service.module2.impl;

import org.yy.demo.service.module2.Module2Service;

public class Module2ServiceImpl implements Module2Service {

	@Override
	public String sayHello(String name) {
		return "hello" + name;
	}

}
