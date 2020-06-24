package br.com.bankintegration.casebank.monitorstartinput.core;

import br.com.bankintegration.casebank.monitorstartinput.adapter.mongo.io.entities.Application;

public interface ApplicationCore {

	
	void processMessageMainframe(Application application);
	
	
	
}
