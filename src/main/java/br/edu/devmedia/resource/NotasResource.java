package br.edu.devmedia.resource;

import br.edu.devmedia.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notas")
public class NotasResource {

    @Autowired
    private Nota nota;
}
