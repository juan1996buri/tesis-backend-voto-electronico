package ec.edu.insteclrg.app.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.insteclrg.service.crud.GrupoService;

@RestController
@RequestMapping(value = "/api/v1.0/grupo")
public class GrupoController {

	@Autowired
	private GrupoService service;
	
	
	
	
}
