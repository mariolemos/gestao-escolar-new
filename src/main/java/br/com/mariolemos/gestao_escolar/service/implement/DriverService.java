package br.com.mariolemos.gestao_escolar.service.implement;

import br.com.digidata.crud.service.CrudService;
import br.com.mariolemos.gestao_escolar.model.Driver;
import br.com.mariolemos.gestao_escolar.service.IDriverService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DriverService extends CrudService<Driver, UUID> implements IDriverService<Driver> {

    public DriverService(JpaRepository<Driver, UUID> repository) {
        super(repository);
    }
}
