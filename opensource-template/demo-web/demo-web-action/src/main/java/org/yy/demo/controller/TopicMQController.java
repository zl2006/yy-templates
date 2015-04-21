package org.yy.demo.controller;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.yy.framework.base.controller.AbstractController;

/**
 * ActiveMQ主题消息演示
 */
@Controller
@RequestMapping("/topic")
public class TopicMQController extends AbstractController {

	@Resource(name = "topicJmsTemplate")
	private JmsTemplate topicJmsTemplate;

	@Override
	protected void setModuleName() {

	}

	@RequestMapping("/publish")
	public String publish(@RequestParam("msg") final String msg) {
		topicJmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				System.out.println("topic name 是"
						+ topicJmsTemplate.getDefaultDestination().toString()
						+ "，发布消息内容为:\t" + msg);
				return session.createTextMessage(msg);
			}
		});

		return "";
	}

}
