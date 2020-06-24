package br.com.itau.caseitau.monitorstartinput.core;

import br.com.itau.caseitau.monitorstartinput.adapter.mongo.io.entities.Application;

public interface ApplicationCore {

	
	void processMessageMainframe(Application application);
	
	
	
}
