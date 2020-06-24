package br.com.itau.caseitau.monitorstartinput.adapter.mongo.io.dao;

import org.bson.Document;

public interface ApplicationDAO {

	
	Document getApplication(String processorFile);
	
	public void save( String organization);
	
}
