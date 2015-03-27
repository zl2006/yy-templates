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
}
