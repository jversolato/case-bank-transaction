package br.com.bankintegration.casebank.monitorstartinput.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
public class JMSOutputConfig {


	@Value("${spring.activemq.broker-url}")
	private String brokerURL;

	@Value("${spring.activemq.user}")
	private String brokerUsername;

	@Value("${spring.activemq.password}")
	private String brokerPassword;

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory =
				new ActiveMQConnectionFactory(brokerUsername, brokerPassword, brokerURL);
		return activeMQConnectionFactory;
	}

	@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
		return new CachingConnectionFactory(connectionFactory());
	}

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(cachingConnectionFactory());
		factory.setPubSubDomain(false);
		return factory;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(cachingConnectionFactory());
	}
}
