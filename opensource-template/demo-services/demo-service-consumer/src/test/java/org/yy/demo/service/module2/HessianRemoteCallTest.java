/*
* 文 件 名:  Module2ServiceTest.java
* 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
* 描    述:  <描述>
* 修 改 人:  zhouliang
* 修改时间:  2014年7月22日
* 修改内容:  <修改内容>
*/
package org.yy.demo.service.module2;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.yy.demo.service.module2.impl.HessianRemoteCall;
import org.yy.framework.base.test.AbstractSpringTest;

/**
* <一句话功能简述>
* <功能详细描述>
* 
* @author  zhouliang
* @version  [0.1, 2014年7月22日]
* @since  [APP-DEMO/0.1]
*/
public class HessianRemoteCallTest extends AbstractSpringTest {
    
    @Resource(name = "hessianRemoteCall")
    private HessianRemoteCall hessianRemoteCall;
    
    @Test
    public void testRemote() throws Exception{
        Assert.assertEquals("hellodfd", hessianRemoteCall.remote("dfd") );
    }
}
