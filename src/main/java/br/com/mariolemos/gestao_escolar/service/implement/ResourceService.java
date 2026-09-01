package br.com.mariolemos.gestao_escolar.service.implement;

import br.com.digidata.crud.service.CrudService;
import br.com.mariolemos.gestao_escolar.model.Resource;
import br.com.mariolemos.gestao_escolar.repository.ResourceRepository;
import br.com.mariolemos.gestao_escolar.service.IResourceService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ResourceService extends CrudService<Resource, UUID>
        implements IResourceService<Resource> {

    private final ResourceRepository repository;

    public ResourceService(ResourceRepository repository) {
        super(repository);
        this.repository = repository;
    }
}