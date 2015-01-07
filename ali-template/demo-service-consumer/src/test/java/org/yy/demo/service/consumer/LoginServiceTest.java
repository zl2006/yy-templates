 /*
 * 文 件 名:  LoginServiceTest.java
 * 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  zhouliang
 * 修改时间:  2014年7月23日
 * 修改内容:  <修改内容>
 */
package org.yy.demo.service.consumer;


import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.yy.framework.base.test.AbstractSpringTest;
import org.yy.framework.basedata.exception.ServiceException;

 /**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  zhouliang
 * @version  [版本号, 2014年7月23日]
 * @since  [产品/模块版本]
 */
public class LoginServiceTest extends AbstractSpringTest{
    
    @Resource(name="loginService")
    private LoginService loginService;
    /**
     * Test method for {@link org.yy.demo.service.consumer.LoginService#login(java.lang.String)}.
     */
    @Test
    public void testLogin()throws ServiceException , Exception{
        Assert.assertTrue(  loginService.login("18665867002") );
        Thread.sleep(100000);
    }
    
}
