package Taigo_D3v.Projeto.Amostra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Taigo_D3v.Projeto.Amostra.domain.Telefone;
import Taigo_D3v.Projeto.Amostra.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository telefoneRepository;

	public Telefone findById(Integer id) {
		Optional<Telefone> telefone = telefoneRepository.findById(id);

		if (telefone.isPresent()) {
			return telefone.get();
		} else {
			throw new RuntimeException("Telefone não encontrada com o ID: " + id);
		}
	}

	public Telefone save(Telefone telefone) {

		if (telefone.getNumero() == null) {
			throw new IllegalArgumentException("O campo de telefone não pode ser vazio.");
		}

		return telefoneRepository.save(telefone);
	}
	
	public List<Telefone> findAll(){
		return telefoneRepository.findAll();
	}
	
	public Telefone update(Integer id, Telefone telefone) {
		
		Telefone telefoneExistente = findById(id);
		
		telefoneExistente.setNumero(telefoneExistente.getNumero());
		
		return telefoneRepository.save(telefoneExistente);
	}
	
	public void deleteById(Integer id) {
        findById(id);
        telefoneRepository.deleteById(id);
    }

}
