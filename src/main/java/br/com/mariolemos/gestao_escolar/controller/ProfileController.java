package br.com.mariolemos.gestao_escolar.controller;

import br.com.digidata.crud.controller.CrudController;
import br.com.digidata.crud.controller.dto.request.IRequest;
import br.com.digidata.crud.controller.dto.response.IResponse;
import br.com.mariolemos.gestao_escolar.controller.dto.request.ProfileRequest;
import br.com.mariolemos.gestao_escolar.controller.dto.request.VehicleRequest;
import br.com.mariolemos.gestao_escolar.controller.dto.response.ProfileResponse;
import br.com.mariolemos.gestao_escolar.controller.dto.response.VehicleResponse;
import br.com.mariolemos.gestao_escolar.model.Profile;
import br.com.mariolemos.gestao_escolar.model.Vehicle;
import br.com.mariolemos.gestao_escolar.service.IProfileService;
import br.com.mariolemos.gestao_escolar.service.IVeichicleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profile")
public class ProfileController extends CrudController<ProfileRequest, ProfileResponse, Profile> {

    private IProfileService<Profile> service;

    public ProfileController(IProfileService<Profile> service, IRequest<ProfileRequest, Profile> request, IResponse<Profile, ProfileResponse> response) {
        super(service, request, response);
        this.service = service;
    }
}
