/*
* 文 件 名:  UserConsumer.java
* 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
* 描    述:  <描述>
* 修 改 人:  zhouliang
* 修改时间:  2014年7月24日
* 修改内容:  <修改内容>
*/
package org.yy.demo.message.consumer;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
* <一句话功能简述>
* <功能详细描述>
* 
* @author  zhouliang
* @version  [版本号, 2014年7月24日]
* @since  [产品/模块版本]
*/
public class DemoConsumer {
    
    private DefaultMQPushConsumer consumer;
    
    public void subscribe()
        throws Exception {
        /**
         * 订阅指定topic下tags分别等于TagA或TagC或TagD
         */
        consumer.subscribe("USER", "REGISTER || FIND");
        
        /**
         * 订阅指定topic下所有消息<br>
         * 注意：一个consumer对象可以订阅多个topic
         */
        //consumer.subscribe("TopicTest2", "*");
        
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            
            /**
             * 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
             */
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                
                System.out.println(Thread.currentThread().getName() + " Receive New Messages: " + msgs.size());
                
                MessageExt msg = msgs.get(0);
                if (msg.getTopic().equals("USER")) {
                    // 执行TopicTest1的消费逻辑
                    if (msg.getTags() != null && msg.getTags().equals("REGISTER")) {
                        // 执行REGISTER的消费
                        System.out.println("REGISTER" + new String(msg.getBody()));
                    }
                    else if (msg.getTags() != null && msg.getTags().equals("FIND")) {
                        System.out.println("FIND" + new String(msg.getBody()));
                        // 执行FIND的消费
                    }
                }
                else if (msg.getTopic().equals("TopicTest2")) {
                    System.out.println(new String(msg.getBody()));
                }
                
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
      
        consumer.start();
    }
    
    /**
    * @param 对consumer进行赋值
    */
    public void setConsumer(DefaultMQPushConsumer consumer) {
        this.consumer = consumer;
    }
    
}
