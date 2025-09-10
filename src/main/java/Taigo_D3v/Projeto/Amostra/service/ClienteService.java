package Taigo_D3v.Projeto.Amostra.service;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
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

    @Transactional
	public Cliente update(Integer id, Cliente clienteComNovosDados) {

        //1. procura o cliente existente
		Cliente clienteExistente = findById(id);


        //2. atualiza os dados simple de cliente
		clienteExistente.setCpfOuCnpj(clienteComNovosDados.getCpfOuCnpj());
		clienteExistente.setEmail(clienteComNovosDados.getEmail());
		clienteExistente.setNome(clienteComNovosDados.getNome());
		clienteExistente.setTipo(clienteComNovosDados.getTipo());

        //3. limpa a lista de telefone antiga
        clienteExistente.getTelefone().clear();

        //4. Adiciona todos os telefones da requisição na lista do cliente existente
        if(clienteComNovosDados.getTelefone() != null){
            clienteExistente.getTelefone().addAll(clienteComNovosDados.getTelefone());
        }
		//5. salva o cliente. O JPA irá sincronizar todas as midanças no banco.
		return clienteRepository.save(clienteExistente);
	}
	
	public void deleteById(Integer id) {
        findById(id);
        clienteRepository.deleteById(id);
    }

}
