package br.com.mariolemos.gestao_escolar.controller.dto.request;

import br.com.digidata.crud.controller.dto.request.IRequest;
import br.com.mariolemos.gestao_escolar.model.Location;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class LocationRequest implements IRequest<LocationRequest, Location> {

    private UUID vehicleId;
    private Double latitude;
    private Double longitude;

    @Override
    public Location to(LocationRequest locationRequest) {
        return Location.builder().vehicleId(locationRequest.getVehicleId()).latitude(locationRequest.getLatitude()).longitude(locationRequest.getLongitude()).createdAt(LocalDateTime.now()).build();
    }

    @Override
    public List<Location> to(List<LocationRequest> locationRequest) {
        return locationRequest.stream().map(this::to).toList();
    }
}
