package br.edu.devmedia.resource;

import br.edu.devmedia.model.Nota;
import br.edu.devmedia.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
