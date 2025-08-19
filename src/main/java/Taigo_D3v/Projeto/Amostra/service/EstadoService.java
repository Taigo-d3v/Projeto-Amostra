package Taigo_D3v.Projeto.Amostra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Taigo_D3v.Projeto.Amostra.domain.Estado;
import Taigo_D3v.Projeto.Amostra.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public Estado findById(Integer id) {
		Optional<Estado> estado = estadoRepository.findById(id);

		if (estado.isPresent()) {
			return estado.get();
		} else {
			throw new RuntimeException("Estado não encontrada com o ID: " + id);
		}
	}

	public Estado save(Estado estado) {

		if (estado.getNome() == null || estado.getNome().isEmpty()) {
			throw new IllegalArgumentException("O nome do estado não pode ser vazio.");
		}

		return estadoRepository.save(estado);
	}
	
	public List<Estado> findAll(){
		return estadoRepository.findAll();
	}
	
	public Estado update(Integer id, Estado estado) {
		
		Estado estadoExistente = findById(id);
		
		estadoExistente.setNome(estadoExistente.getNome());
		
		return estadoRepository.save(estadoExistente);
	}
	
	public void deleteById(Integer id) {
        findById(id);
        estadoRepository.deleteById(id);
    }

}
