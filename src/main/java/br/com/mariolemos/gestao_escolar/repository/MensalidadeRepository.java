package br.com.mariolemos.gestao_escolar.repository;

import br.com.mariolemos.gestao_escolar.model.Mensalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long> {
}
