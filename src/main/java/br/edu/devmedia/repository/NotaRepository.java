package br.edu.devmedia.repository;

import br.edu.devmedia.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepository extends JpaRepository <Nota, Long> {

}
