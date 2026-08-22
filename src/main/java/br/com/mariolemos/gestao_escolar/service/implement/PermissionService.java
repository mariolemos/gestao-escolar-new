package br.com.mariolemos.gestao_escolar.service.implement;

import br.com.digidata.crud.service.CrudService;
import br.com.mariolemos.gestao_escolar.model.Permission;
import br.com.mariolemos.gestao_escolar.repository.PermissionRepository;
import br.com.mariolemos.gestao_escolar.service.IPermissionService;
import br.com.mariolemos.gestao_escolar.service.IUserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PermissionService extends CrudService<Permission, UUID>
        implements IPermissionService<Permission> {

    private final PermissionRepository repository;
    private final UserService usuarioService;

    public PermissionService(PermissionRepository repository,UserService usuarioService) {
        super(repository);
        this.repository = repository;
        this.usuarioService = usuarioService;
    }

    @Override
    public boolean hasPermission(String resource, String permission) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null ||
                !authentication.isAuthenticated()) {
            return false;
        }

        String username = authentication.getName();

        return usuarioService.hasPermission(
                username,
                resource,
                permission
        );
    }
}