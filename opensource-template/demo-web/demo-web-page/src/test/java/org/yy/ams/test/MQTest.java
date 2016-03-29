///*
//* 文 件 名:  MQTest.java
//* 版    权:  YY Technologies Co., Ltd. Copyright 2012-2013,  All rights reserved
//* 描    述:  <描述>
//* 修 改 人:  zhouliang
//* 修改时间:  2016年3月29日
//* 修改内容:  <修改内容>
//*/
//package org.yy.ams.test;
//
//import javax.jms.JMSException;
//import javax.jms.MessageProducer;
//import javax.jms.Queue;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.amazon.sqs.javamessaging.AmazonSQSMessagingClientWrapper;
//import com.amazon.sqs.javamessaging.SQSConnection;
//import com.amazon.sqs.javamessaging.SQSConnectionFactory;
//import com.amazonaws.auth.profile.ProfileCredentialsProvider;
//import com.amazonaws.regions.Region;
//import com.amazonaws.regions.Regions;
//
///**
//* <一句话功能简述>
//* <功能详细描述>
//* 
//* @author  zhouliang
//* @version  [版本号, 2016年3月29日]
//* @since  [产品/模块版本]
//*/
//public class MQTest {
//    
//    SQSConnectionFactory connectionFactory;
//    
//    SQSConnection connection;
//    
//    @Before
//    public void setUp() {
//        connectionFactory =
//            SQSConnectionFactory.builder()
//                .withRegion(Region.getRegion(Regions.CN_NORTH_1))
//                .withAWSCredentialsProvider(new ProfileCredentialsProvider())
//                .build();
//        try {
//            connection = connectionFactory.createConnection();
//        }
//        catch (JMSException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//    
//    @Test
//    public void createQueue()
//        throws JMSException {
//        // Get the wrapped client
//        AmazonSQSMessagingClientWrapper client = connection.getWrappedAmazonSQSClient();
//        // Create an SQS queue named 'TestQueue' – if it does not already exist.
//        if (!client.queueExists("TestQueue")) {
//            client.createQueue("TestQueue");
//        }
//    }
//    
//    @Test
//    public void sendMsg()
//        throws JMSException {
//        // Create the non-transacted session with AUTO_ACKNOWLEDGE mode
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        
//        // Create a queue identity with name 'TestQueue' in the session
//        Queue queue = session.createQueue("TestQueue");
//        // Create a producer for the 'TestQueue'.
//        MessageProducer producer = session.createProducer(queue);
//        // Create the text message.
//        TextMessage message = session.createTextMessage("Hello World!");
//        
//        // Send the message.
//        producer.send(message);
//        System.out.println("JMS Message " + message.getJMSMessageID());
//    }
//}
