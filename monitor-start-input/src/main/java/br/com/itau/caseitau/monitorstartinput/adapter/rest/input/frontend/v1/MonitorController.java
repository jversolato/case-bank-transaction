package br.com.itau.caseitau.monitorstartinput.adapter.rest.input.frontend.v1;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.caseitau.monitorstartinput.adapter.mongo.io.entities.Application;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/monitor")
public class MonitorController {
	
	/**
	 * @todo Implentar controller que será utilizado para consulta, do processamento do lote de leitura de arquivos e
	 * ou registros e ver qual o status no momento  EM PROCESSAMENTO, PROCESSADO, ERRO AO PROCESSAR
	 * 
	 */
	@GetMapping(value = "/{processId}")
    public Application getApplication(
            @PathVariable Long processid,
            HttpServletResponse response) {

		log.info("Call method getApplication");
		
        return null;
    }

}
