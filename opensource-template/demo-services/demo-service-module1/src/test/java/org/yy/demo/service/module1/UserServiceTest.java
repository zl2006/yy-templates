/*
* 文 件 名:  UserServiceTest.java
* 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
* 描    述:  <描述>
* 修 改 人:  zhouliang
* 修改时间:  2013年12月1日
* 修改内容:  <修改内容>
*/
package org.yy.demo.service.module1;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.yy.demo.dao.UserDao;
import org.yy.demo.model.User;
import org.yy.demo.service.module1.impl.UserServiceImpl;
import org.yy.framework.base.test.AbstractSpringTest;

/**
* <一句话功能简述>
* <功能详细描述>
* 
* @author  zhouliang
* @version  [0.1, 2013年12月1日]
* @since  [APP-DEMO/0.1]
*/
public class UserServiceTest extends AbstractSpringTest {
    
    @Resource(name = "userService")
    private UserService userService;
    
    @Test
    public void testFindUser()
        throws Exception {
        Assert.assertNotNull(userService.findUser("18665867002"));
    }
    
    @Test
    public void testFindUserByMock()throws Exception{
    	
    	UserDao udao = Mockito.mock(UserDao.class);
    	UserServiceImpl us = new UserServiceImpl();
    	
    	User u = new User();
    	u.setLoginID("18665867002");
    	u.setName("liangzhou20066");
    	Mockito.when(udao.findUser("18665867002")).thenReturn(u);
    	us.setUserDao(udao);
    	
    	User result = us.findUser("18665867002");
    	
    	Assert.assertSame("liangzhou20066", result.getName());
    	Assert.assertSame("18665867002", result.getLoginID());
    }
}
