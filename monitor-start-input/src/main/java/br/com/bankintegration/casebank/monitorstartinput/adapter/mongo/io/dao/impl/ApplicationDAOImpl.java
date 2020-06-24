package br.com.bankintegration.casebank.monitorstartinput.adapter.mongo.io.dao.impl;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import br.com.bankintegration.casebank.monitorstartinput.adapter.mongo.io.dao.ApplicationDAO;
/***
 * @Todo Classe responsavel por salvar no mongodb o processo executado para leitura
 * dos registros e salvar com um Status default de Em Processamento 
 * 
 */
@Service
public class ApplicationDAOImpl implements ApplicationDAO{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	private static final String COLLECTION_NAME = "application";
	
	
	@Override
	public Document getApplication(String processId) {
	
		return null;
	}
	
	@Override
	public void save( String organization) {
		Document doc = Document.parse(organization);
		mongoTemplate.insert(doc, COLLECTION_NAME);
	}


}
