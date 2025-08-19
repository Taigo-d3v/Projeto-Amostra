package Taigo_D3v.Projeto.Amostra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Taigo_D3v.Projeto.Amostra.domain.Endereco;
import Taigo_D3v.Projeto.Amostra.repository.EnderecoRepository;


@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;	
			
	public Endereco findById(Integer id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);

		if (endereco.isPresent()) {
			return endereco.get();
		} else {
			throw new RuntimeException("Endereço não encontrado com o ID: " + id);
		}
	}

	public Endereco save(Endereco endereco) {

		if (endereco.getBairro() == null || endereco.getBairro().isEmpty()
				|| endereco.getCep() == null || endereco.getCep().isEmpty()
				|| endereco.getLogradouro() == null || endereco.getLogradouro().isEmpty()) {
			throw new IllegalArgumentException("O endereço está incompleto");
		}

		return enderecoRepository.save(endereco);
	}
	
	public List<Endereco> findAll(){
		return enderecoRepository.findAll();
	}
	
	public Endereco update(Integer id, Endereco endereco) {
		
		Endereco enderecoExistente = findById(id);
		
		enderecoExistente.setBairro(endereco.getBairro());
		enderecoExistente.setCep(endereco.getCep());
		enderecoExistente.setCidade(endereco.getCidade());
		enderecoExistente.setComplemento(endereco.getComplemento());
		enderecoExistente.setLogradouro(endereco.getLogradouro());
		
		return enderecoRepository.save(enderecoExistente);
	}
	
	public void deleteById(Integer id) {
        findById(id);
        enderecoRepository.deleteById(id);
    }

}
