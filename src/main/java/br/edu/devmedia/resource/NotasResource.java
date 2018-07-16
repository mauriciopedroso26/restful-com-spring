package br.edu.devmedia.resource;

import br.edu.devmedia.model.Nota;
import br.edu.devmedia.repository.NotaRepository;
import org.springframework.beans.BeanUtils;
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

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/notas")
public class NotasResource {

    @Autowired
    private NotaRepository notaRepository;

    @PostMapping
    public Nota adicionar(@Valid @RequestBody Nota nota){
        return notaRepository.save(nota);
    }

    @GetMapping
    public List <Nota> listar(){
        return notaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Nota> buscar(@PathVariable Long id){
        Nota nota = notaRepository.getOne(id);

        if(nota == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(nota);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Nota> atualizar(@PathVariable Long id, @Valid @RequestBody Nota nota){
        Nota existente = notaRepository.getOne(id);

        if(existente == null){
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(nota, existente, "id");
        existente = notaRepository.save(existente);
        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> remover(@PathVariable Long id){
        Nota nota = notaRepository.getOne(id);

        if(nota == null){
            return  ResponseEntity.notFound().build();
        }

        notaRepository.delete(nota);
        return ResponseEntity.noContent().build();
    }
}
