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

import Taigo_D3v.Projeto.Amostra.domain.Estado;
import Taigo_D3v.Projeto.Amostra.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/{id}")
    public ResponseEntity<Estado> findById(@PathVariable Integer id) {
    	Estado estado = estadoService.findById(id);
        return ResponseEntity.ok().body(estado);
    }

    @GetMapping
    public ResponseEntity<List<Estado>> findAll() {
        List<Estado> estado = estadoService.findAll();
        return ResponseEntity.ok().body(estado);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Estado estado) {
    	Estado savedEstado = estadoService.save(estado);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEstado.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Estado estado) {
    	estadoService.update(id, estado);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    	estadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
