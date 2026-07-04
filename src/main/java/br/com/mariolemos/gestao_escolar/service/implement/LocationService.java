package br.com.mariolemos.gestao_escolar.service.implement;

import br.com.digidata.crud.exception.ResourceNotFoundException;
import br.com.mariolemos.gestao_escolar.model.Location;
import br.com.mariolemos.gestao_escolar.model.Vehicle;
import br.com.mariolemos.gestao_escolar.repository.LocationRepository;
import br.com.mariolemos.gestao_escolar.service.ILocationService;
import br.com.mariolemos.gestao_escolar.service.IVeichicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LocationService implements ILocationService<Location> {

    private final LocationRepository repository;
    private final IVeichicleService<Vehicle> veichicleService;

    public Location findByLocation(UUID vehicleId){
        return repository.findTopByVehicleIdOrderByCreatedAtDesc(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Localização não encontrada para o veiculo"));
    }

    @Override
    public Location create(Location location){
        veichicleService.findById(location.getVehicleId());
        return repository.save(location);
    }

}
