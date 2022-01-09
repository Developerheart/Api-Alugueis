package br.com.aluguel.robert.imoveis.service;

import br.com.aluguel.robert.imoveis.model.Proprietario;
import br.com.aluguel.robert.imoveis.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository proprietarioRepository;

	public Proprietario salvar(Proprietario proprietario) {
		return proprietarioRepository.save(proprietario);
	}



}
