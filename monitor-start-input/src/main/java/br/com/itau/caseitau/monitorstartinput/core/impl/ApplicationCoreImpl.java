package br.com.itau.caseitau.monitorstartinput.core.impl;

import org.springframework.stereotype.Service;

import br.com.itau.caseitau.monitorstartinput.adapter.mongo.io.entities.Application;
import br.com.itau.caseitau.monitorstartinput.core.ApplicationCore;
import lombok.extern.slf4j.Slf4j;


/***
 *
 * @todo  Esta classe será responsável pelas regras de negócio de acordo com a fila
 * chamada, podendo ter uma classe para cada tipo de fila chamada
 * 
 */
@Slf4j
@Service
public class ApplicationCoreImpl implements ApplicationCore{

	@Override
	public void processMessageMainframe(Application application) {
		// TODO Auto-generated method stub
		
		
		log.info("Mensagem recebida canal: {}", application.getChannel());
	}

}
