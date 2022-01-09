package br.com.aluguel.robert.imoveis.controller;

import br.com.aluguel.robert.imoveis.model.Proprietario;
import br.com.aluguel.robert.imoveis.service.ProprietarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/proprietario")
public class ProprietarioController {
	private static final Logger logger = LoggerFactory.getLogger(ProprietarioController.class);
	@Autowired
	private ProprietarioService service;

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Proprietario proprietario) {
		try {
			if (proprietario.getCpf().length() > 11){
				throw new Exception("DEU RUIM NO CPF");
			}
			Proprietario resposta = service.salvar(proprietario);

			return ResponseEntity.status(HttpStatus.CREATED).body(proprietario);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.internalServerError().build();
		}

	}


}
