package br.com.mariolemos.gestao_escolar.controller;

import br.com.digidata.crud.controller.dto.request.IRequest;
import br.com.digidata.crud.controller.dto.response.IResponse;
import br.com.mariolemos.gestao_escolar.controller.dto.request.PermissionRequest;
import br.com.mariolemos.gestao_escolar.controller.dto.response.PermissionResponse;
import br.com.mariolemos.gestao_escolar.model.Permission;
import br.com.mariolemos.gestao_escolar.security.permission.ResourcePermission;
import br.com.mariolemos.gestao_escolar.service.IPermissionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("permission")
@ResourcePermission("PERMISSION")
public class PermissionController
        extends BaseCrudController<PermissionRequest, PermissionResponse, Permission> {

    private final IPermissionService<Permission> service;

    public PermissionController(
            IPermissionService<Permission> service,
            IRequest<PermissionRequest, Permission> request,
            IResponse<Permission, PermissionResponse> response) {

        super(service, request, response);
        this.service = service;
    }
}