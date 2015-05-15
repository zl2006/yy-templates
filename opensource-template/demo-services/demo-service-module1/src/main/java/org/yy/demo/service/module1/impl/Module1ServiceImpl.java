/*
 * 文 件 名:  Module1ServiceImpl.java
 * 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouliang
 * 修改时间:  2014年7月22日
 * 修改内容:  <修改内容>
 */
package org.yy.demo.service.module1.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.yy.demo.service.module1.Module1Service;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author zhouliang
 * @version [0.1, 2014年7月22日]
 * @since [APP-DEMO/0.1]
 */
@Service("module1Service")
public class Module1ServiceImpl implements Module1Service {

	private static final Logger logger = LoggerFactory
			.getLogger(Module1ServiceImpl.class);

	/** {@inheritDoc} */
	@Override
	public String module1Method() {
		logger.info("call module1Method");
		return "module1";
	}

}
