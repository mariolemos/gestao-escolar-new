package br.com.mariolemos.gestao_escolar.controller;

import br.com.digidata.crud.controller.dto.request.IRequest;
import br.com.digidata.crud.controller.dto.response.IResponse;
import br.com.mariolemos.gestao_escolar.controller.dto.request.VehicleRequest;
import br.com.mariolemos.gestao_escolar.controller.dto.response.VehicleResponse;
import br.com.mariolemos.gestao_escolar.model.Vehicle;
import br.com.mariolemos.gestao_escolar.security.permission.ResourcePermission;
import br.com.mariolemos.gestao_escolar.service.IVeichicleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vehicle")
@ResourcePermission("VEHICLE")
public class VehicleController extends BaseCrudController<VehicleRequest, VehicleResponse, Vehicle> {

    private IVeichicleService<Vehicle> service;

    public VehicleController(IVeichicleService<Vehicle> service, IRequest<VehicleRequest, Vehicle> request, IResponse<Vehicle, VehicleResponse> response) {
        super(service, request, response);
        this.service = service;
    }
}
