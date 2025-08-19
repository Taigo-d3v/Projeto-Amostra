package Taigo_D3v.Projeto.Amostra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Taigo_D3v.Projeto.Amostra.domain.Cliente;
import Taigo_D3v.Projeto.Amostra.repository.ClienteRepository;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente findById(Integer id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);

		if (cliente.isPresent()) {
			return cliente.get();
		} else {
			throw new RuntimeException("Cliente não encontrado com o ID: " + id);
		}
	}

	public Cliente save(Cliente cliente) {

		if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
			throw new IllegalArgumentException("O nome do cliente não pode ser vazio.");
		}

		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Cliente update(Integer id, Cliente cliente) {
		
		Cliente clienteExistente = findById(id);
		
		clienteExistente.setCpfOuCnpj(cliente.getCpfOuCnpj());
		clienteExistente.setEmail(cliente.getEmail());
		clienteExistente.setNome(cliente.getNome());
		clienteExistente.setTipo(cliente.getTipo());
		
		return clienteRepository.save(clienteExistente);
	}
	
	public void deleteById(Integer id) {
        findById(id);
        clienteRepository.deleteById(id);
    }

}
