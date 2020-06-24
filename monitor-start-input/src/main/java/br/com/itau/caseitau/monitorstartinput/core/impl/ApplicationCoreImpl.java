package br.com.itau.caseitau.monitorstartinput.core.impl;

import org.springframework.stereotype.Service;

import br.com.itau.caseitau.monitorstartinput.adapter.mongo.io.entities.Application;
import br.com.itau.caseitau.monitorstartinput.core.ApplicationCore;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApplicationCoreImpl implements ApplicationCore{

	@Override
	public void processMessageMainframe(Application application) {
		// TODO Auto-generated method stub
		
		
		log.info("Mensagem recebida canal: {}", application.getChannel());
	}

}
