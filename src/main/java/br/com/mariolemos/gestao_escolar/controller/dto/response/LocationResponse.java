package br.com.mariolemos.gestao_escolar.controller.dto.response;

import br.com.digidata.crud.controller.dto.response.IResponse;
import br.com.mariolemos.gestao_escolar.model.Location;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationResponse implements IResponse<Location, LocationResponse> {

    private UUID vehicleId;
    private Double latitude;
    private Double longitude;
    private LocalDateTime createdAt;

    @Override
    public LocationResponse to(Location location) {
        return LocationResponse.builder().longitude(location.getLongitude()).latitude(location.getLatitude()).vehicleId(location.getVehicleId()).createdAt(location.getCreatedAt()).build();
    }

    @Override
    public List<LocationResponse> to(List<Location> locations) {
        return locations.stream().map(this::to).toList();
    }
}
