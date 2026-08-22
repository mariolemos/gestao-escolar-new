package br.com.mariolemos.gestao_escolar.repository;

import br.com.mariolemos.gestao_escolar.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PermissionRepository extends JpaRepository<Permission, UUID> {
}