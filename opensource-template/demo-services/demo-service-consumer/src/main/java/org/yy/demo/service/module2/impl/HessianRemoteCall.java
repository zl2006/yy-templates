package org.yy.demo.service.module2.impl;


import org.yy.demo.service.module2.Module2Service;

public class HessianRemoteCall {

	private Module2Service module2Service;

	public String remote(String name) {
		return module2Service.sayHello(name);
	}

	public Module2Service getModule2Service() {
		return module2Service;
	}

	public void setModule2Service(Module2Service module2Service) {
		this.module2Service = module2Service;
	}

}
