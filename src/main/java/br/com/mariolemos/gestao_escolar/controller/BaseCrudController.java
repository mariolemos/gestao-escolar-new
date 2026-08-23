package br.com.mariolemos.gestao_escolar.controller;

import br.com.digidata.crud.controller.CrudController;
import br.com.digidata.crud.controller.dto.request.IRequest;
import br.com.digidata.crud.controller.dto.response.IResponse;
import br.com.digidata.crud.service.ICrudService;
import br.com.mariolemos.gestao_escolar.security.permission.ResourcePermission;
import org.springframework.security.access.AccessDeniedException;

import java.util.List;
import java.util.UUID;

public abstract class BaseCrudController<
        Request,
        Response,
        Model>
        extends CrudController<Request, Response, Model> {

    protected BaseCrudController(
            ICrudService<Model, UUID> service,
            IRequest<Request, Model> request,
            IResponse<Model, Response> response) {

        super(service, request, response);
    }

    @Override
    public Response create(Request request) {

        checkPermission("CREATE");

        return super.create(request);
    }

    @Override
    public Response update(
            Request request,
            UUID id) {

        checkPermission("UPDATE");

        return super.update(request, id);
    }

    @Override
    public List<Response> list() {

        checkPermission("VIEW");

        return super.list();
    }

    @Override
    public Response findById(UUID id) {

        checkPermission("VIEW");

        return super.findById(id);
    }

    @Override
    public void delete(UUID id) {

        checkPermission("DELETE");

        super.delete(id);
    }

    private void checkPermission(
            String permission) {

        ResourcePermission resourcePermission =
                getClass().getAnnotation(
                        ResourcePermission.class
                );

        if (resourcePermission == null) {

            throw new IllegalStateException(
                    "O controller "
                            + getClass().getName()
                            + " não possui @ResourcePermission"
            );
        }

        String requiredAuthority =
                resourcePermission.value()
                        + ":"
                        + permission;

        boolean hasPermission =
                org.springframework.security.core.context
                        .SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getAuthorities()
                        .stream()
                        .anyMatch(authority ->
                                authority.getAuthority()
                                        .equals(requiredAuthority)
                        );

        if (!hasPermission) {

            throw new AccessDeniedException(
                    "Usuário não possui a permissão: "
                            + requiredAuthority
            );
        }
    }
}