package br.com.mariolemos.gestao_escolar.repository;

import br.com.mariolemos.gestao_escolar.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    boolean existsBycpf(String cpf);

    Optional<Aluno> findBycpf(String cpf);

    Optional<Aluno> findByResponsavelCpf(String ResponsavelCpf);

    List<Aluno> findAllByResponsavelCpf(String ResponsavelCpf);

}
