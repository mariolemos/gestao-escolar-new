package br.com.mariolemos.gestao_escolar.repository;

import br.com.mariolemos.gestao_escolar.model.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

    boolean existsBycpf(String cpf);

    Optional<Responsavel> findBycpf(String cpf);
}
