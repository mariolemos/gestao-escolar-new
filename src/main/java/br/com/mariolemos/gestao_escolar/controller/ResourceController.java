package br.com.mariolemos.gestao_escolar.controller;

import br.com.digidata.crud.controller.dto.request.IRequest;
import br.com.digidata.crud.controller.dto.response.IResponse;
import br.com.mariolemos.gestao_escolar.controller.dto.request.ResourceRequest;
import br.com.mariolemos.gestao_escolar.controller.dto.response.ResourceResponse;
import br.com.mariolemos.gestao_escolar.model.Resource;
import br.com.mariolemos.gestao_escolar.security.permission.ResourcePermission;
import br.com.mariolemos.gestao_escolar.service.IResourceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resource")
@ResourcePermission("RECURSO")
public class ResourceController
        extends BaseCrudController<ResourceRequest, ResourceResponse, Resource> {

    private final IResourceService<Resource> service;

    public ResourceController(
            IResourceService<Resource> service,
            IRequest<ResourceRequest, Resource> request,
            IResponse<Resource, ResourceResponse> response) {

        super(service, request, response);
        this.service = service;
    }
}