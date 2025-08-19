package Taigo_D3v.Projeto.Amostra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Taigo_D3v.Projeto.Amostra.domain.Cidade;
import Taigo_D3v.Projeto.Amostra.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	public Cidade findById(Integer id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);

		if (cidade.isPresent()) {
			return cidade.get();
		} else {
			throw new RuntimeException("Cidade não encontrada com o ID: " + id);
		}
	}

	public Cidade save(Cidade cliente) {

		if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
			throw new IllegalArgumentException("O nome da cidade não pode ser vazio.");
		}

		return cidadeRepository.save(cliente);
	}
	
	public List<Cidade> findAll(){
		return cidadeRepository.findAll();
	}
	
	public Cidade update(Integer id, Cidade cliente) {
		
		Cidade cidadeExistente = findById(id);
		
		cidadeExistente.setNome(cidadeExistente.getNome());
		
		return cidadeRepository.save(cidadeExistente);
	}
	
	public void deleteById(Integer id) {
        findById(id);
        cidadeRepository.deleteById(id);
    }

}
