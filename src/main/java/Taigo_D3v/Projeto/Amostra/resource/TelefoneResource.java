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

import Taigo_D3v.Projeto.Amostra.domain.Telefone;
import Taigo_D3v.Projeto.Amostra.service.TelefoneService;

@RestController
@RequestMapping("/telefones")
public class TelefoneResource {

    @Autowired
    private TelefoneService telefoneService;

    @GetMapping("/{id}")
    public ResponseEntity<Telefone> findById(@PathVariable Integer id) {
    	Telefone telefone = telefoneService.findById(id);
        return ResponseEntity.ok().body(telefone);
    }

    @GetMapping
    public ResponseEntity<List<Telefone>> findAll() {
        List<Telefone> telefone = telefoneService.findAll();
        return ResponseEntity.ok().body(telefone);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Telefone telefone) {
    	Telefone savedTelefone = telefoneService.save(telefone);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTelefone.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Telefone telefone) {
    	telefoneService.update(id, telefone);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    	telefoneService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
