package com.sclience.survey.common.plugs.jms.advanced;

import com.sclience.survey.common.base.entity.User;
import org.apache.activemq.ScheduledMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

/**
 * JMS用户变更消息生产者.
 *
 * 使用jmsTemplate将用户变更消息分别发送到queue与topic.
 *
 * @author wangkeqiang
 */
public class AdvancedNotifyMessageProducer {

	private JmsTemplate jmsTemplate;
	private Destination notifyQueue;
	private Destination notifyTopic;

	public void sendQueue(final User user) {
		sendMessage(user, notifyQueue);
	}

	public void sendTopic(final User user) {
		sendMessage(user, notifyTopic);
	}

	/**
	 * 使用jmsTemplate的send/MessageCreator()发送Map类型的消息并在Message中附加属性用于消息过滤.
	 */
	private void sendMessage(final User user, Destination destination) {
		jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {

				MapMessage message = session.createMapMessage();
				message.setString("userName", user.getName());
				message.setString("email", user.getEmail());

				message.setStringProperty("objectType", "user");

				return message;
			}
		});
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setNotifyQueue(Destination notifyQueue) {
		this.notifyQueue = notifyQueue;
	}

	public void setNotifyTopic(Destination nodifyTopic) {
		this.notifyTopic = nodifyTopic;
	}

	//test
	public void sendMessage() {
		jmsTemplate.send(notifyTopic, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {

				MapMessage message = session.createMapMessage();

				int delay=10*1000;
				System.out.println("生产消消息");
				message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY,	 delay);
				message.setStringProperty("objectType", "user");

				return message;
			}
		});
	}
}
