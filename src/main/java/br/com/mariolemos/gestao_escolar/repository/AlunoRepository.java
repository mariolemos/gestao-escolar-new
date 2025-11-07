package br.com.mariolemos.gestao_escolar.repository;

import br.com.mariolemos.gestao_escolar.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
