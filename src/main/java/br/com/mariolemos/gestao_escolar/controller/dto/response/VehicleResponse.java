package br.com.mariolemos.gestao_escolar.controller.dto.response;

import br.com.digidata.crud.controller.dto.response.IResponse;
import br.com.mariolemos.gestao_escolar.model.Vehicle;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class VehicleResponse implements IResponse<Vehicle,VehicleResponse> {

    private UUID id;

    private String plate;

    private String model;

    private Integer capacity;

    private Boolean active;

    @Override
    public VehicleResponse to(Vehicle vehicle) {
        return VehicleResponse.builder().active(vehicle.getActive()).capacity(vehicle.getCapacity()).plate(vehicle.getPlate()).model(vehicle.getModel()).id(vehicle.getId()).build();
    }

    @Override
    public List<VehicleResponse> to(List<Vehicle> vehicles) {
        return vehicles.stream().map(this::to).toList();
    }
}
