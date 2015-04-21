package org.yy.demo.msg;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 主题监听器，和队列监听的代码一样。
 */
public class TopicListener implements MessageListener {

	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println("TopicMessageListener \t" + tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}