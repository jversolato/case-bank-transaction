package br.com.bankintegration.casebank.monitorstartinput.adapter.messaging.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


/***
*
* Classe responsavel por conectar a fila que recebe os registro de transacoes 
* de agencia
* 
*/
@Slf4j
@Service
public class MessageOutputCreditCardPortImpl {
	
	
	@Autowired
	private JmsTemplate jmsOutput;
	
	@Value("${application.fl.monitor.channel.creditcard.output}")
	private String creditCardValidation;
	
	@Value("${spring.application.name}")
	private String correlationID;
	
	
	/**
	 * Send a message to broker
	 */
	@Async
	public void sendCreditCardMessage(String message) {

		log.info("Fila: sendCreditCardMessage MENSAGEM ENVIADA: {}", message);
		
		
		jmsOutput.convertAndSend(creditCardValidation, message, m -> {
			m.setJMSCorrelationID(correlationID);
			return m;
		});
	}
	

}
