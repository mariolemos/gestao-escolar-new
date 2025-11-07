package br.com.mariolemos.gestao_escolar.repository;

import br.com.mariolemos.gestao_escolar.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
