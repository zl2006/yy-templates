package org.yy.demo.controller;

import javax.annotation.Resource;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.yy.framework.base.controller.AbstractController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.MessageCreator;

/**
 * ActiveMQ队列消息演示
 * 
 * @author zhouliang
 *
 */
@Controller
@RequestMapping("/queue")
public class QueueMQController extends AbstractController {

	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;
	
	@Resource(name = "queueDestination2")
	private Queue queue2;

	// 发送消息
	@RequestMapping("/send_msg")
	public String sendMsg(@RequestParam("msg") final String msg)
			throws Exception {
		String destination = jmsTemplate.getDefaultDestination().toString();
		System.out.println("向队列" + destination + "发送了消息------------" + msg);
		jmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});

		return "";
	}

	// 发送消息
	@RequestMapping("/send_msg2")
	public String sendMsg2(@RequestParam("msg") final String msg)
			throws Exception {
		String destination = queue2.toString();
		System.out.println("向队列" + destination + "发送了消息------------" + msg);
		jmsTemplate.send(queue2, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});

		return "";
	}

	// 接受消息
	@RequestMapping("/receive")
	public String receiveMsg() {
		TextMessage tm = (TextMessage) jmsTemplate.receive();
		try {
			System.out.println("从队列"
					+ jmsTemplate.getDefaultDestination().toString()
					+ "收到了消息：\t" + tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	protected void setModuleName() {

	}

}
