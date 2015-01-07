/*
* 文 件 名:  DemoConsumerTest.java
* 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
* 描    述:  <描述>
* 修 改 人:  zhouliang
* 修改时间:  2014年7月24日
* 修改内容:  <修改内容>
*/
package org.yy.demo.message.consumer;


import javax.annotation.Resource;

import org.junit.Test;
import org.yy.framework.base.test.AbstractSpringTest;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;

/**
* <一句话功能简述>
* <功能详细描述>
* 
* @author  zhouliang
* @version  [版本号, 2014年7月24日]
* @since  [产品/模块版本]
*/
public class DemoConsumerTest extends AbstractSpringTest {
    
    @Resource(name = "consumer")
    private DefaultMQPushConsumer consumer;
    
    /**
     * Test method for {@link org.yy.demo.message.consumer.DemoConsumer#subscribe()}.
     */
    @Test
    public void testSubscribe()
        throws Exception {
        Thread.sleep(100000000);
    }
    
}
