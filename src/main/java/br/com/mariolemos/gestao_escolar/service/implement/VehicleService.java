package br.com.mariolemos.gestao_escolar.service.implement;

import br.com.digidata.crud.service.CrudService;
import br.com.mariolemos.gestao_escolar.model.Vehicle;
import br.com.mariolemos.gestao_escolar.repository.VehicleRepository;
import br.com.mariolemos.gestao_escolar.service.IVeichicleService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VehicleService extends CrudService<Vehicle, UUID> implements IVeichicleService<Vehicle> {

    private VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
