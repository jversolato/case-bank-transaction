package br.com.bankintegration.casebank.monitorstartinput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("br.com.bankintegration.casebank.adapter.oracle.io.entities")
@ComponentScan({"br.com.bankintegration.casebank.monitorstartinput.adapter.mongo.io", "br.com.bankintegration.casebank.monitorstartinput.core", 
	"br.com.bankintegration.casebank.monitorstartinput.config"})
public class MonitorStartInputApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorStartInputApplication.class, args);
	}

}
