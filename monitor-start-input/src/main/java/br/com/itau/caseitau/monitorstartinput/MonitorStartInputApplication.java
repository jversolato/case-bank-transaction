package br.com.itau.caseitau.monitorstartinput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("br.com.itau.caseitau.adapter.oracle.io.entities")
@ComponentScan({"br.com.itau.caseitau.monitorstartinput.adapter.mongo.io", "br.com.itau.caseitau.monitorstartinput.core", 
	"br.com.itau.caseitau.monitorstartinput.config"})
public class MonitorStartInputApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorStartInputApplication.class, args);
	}

}
