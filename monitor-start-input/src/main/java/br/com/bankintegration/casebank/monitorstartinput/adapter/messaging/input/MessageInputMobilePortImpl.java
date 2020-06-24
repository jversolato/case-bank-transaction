package br.com.bankintegration.casebank.monitorstartinput.adapter.messaging.input;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/***
*
* Classe responsavel por conectar a fila que recebe os registro de transacoes 
* de mobile
* 
*/
@Service
public class MessageInputMobilePortImpl {


	@JmsListener(destination = "${application.fl.monitor.channel.mobile.input}")
	public void newResponsibleCorpReceiver(String message) {
		
		//CHAMADA PARA O CORE responsavel por tratar as validacoes de mobile
	}

}
