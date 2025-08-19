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

import Taigo_D3v.Projeto.Amostra.domain.Cidade;
import Taigo_D3v.Projeto.Amostra.service.CidadeService;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> findById(@PathVariable Integer id) {
    	Cidade cidade = cidadeService.findById(id);
        return ResponseEntity.ok().body(cidade);
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> findAll() {
        List<Cidade> cidade = cidadeService.findAll();
        return ResponseEntity.ok().body(cidade);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Cidade cidade) {
    	Cidade savedCidade = cidadeService.save(cidade);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCidade.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Cidade cidade) {
    	cidadeService.update(id, cidade);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
    	cidadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
