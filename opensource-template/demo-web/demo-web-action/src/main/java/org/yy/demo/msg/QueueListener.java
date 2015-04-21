package org.yy.demo.msg;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

//队列消息监听器
public class QueueListener implements MessageListener {

	// 当收到消息时，自动调用该方法。
	public void onMessage(Message message) {
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println("ConsumerMessageListener收到了文本消息：\t"
					+ tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}