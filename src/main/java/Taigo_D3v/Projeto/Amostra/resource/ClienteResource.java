package Taigo_D3v.Projeto.Amostra.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Taigo_D3v.Projeto.Amostra.domain.Cliente;
import Taigo_D3v.Projeto.Amostra.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		Cliente cliente = clienteService.findById(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> cliente = clienteService.findAll();
        return ResponseEntity.ok().body(cliente);
    }

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Cliente cliente) {
		Cliente savedCliente = clienteService.save(cliente);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCliente.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
		clienteService.update(id, cliente);
        return ResponseEntity.noContent().build();
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
		clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}