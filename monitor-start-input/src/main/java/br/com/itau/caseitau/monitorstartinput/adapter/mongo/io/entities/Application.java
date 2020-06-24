package br.com.itau.caseitau.monitorstartinput.adapter.mongo.io.entities;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Application implements Serializable{

	@Id
	private ObjectId id;
	private String fileName;
	private String channel;
	private Date dtLastProcess;
	private String status;

	
}