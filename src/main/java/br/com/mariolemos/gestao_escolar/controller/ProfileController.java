package br.com.mariolemos.gestao_escolar.controller;

import br.com.digidata.crud.controller.dto.request.IRequest;
import br.com.digidata.crud.controller.dto.response.IResponse;
import br.com.mariolemos.gestao_escolar.controller.dto.request.ProfileRequest;
import br.com.mariolemos.gestao_escolar.controller.dto.response.ProfileResponse;
import br.com.mariolemos.gestao_escolar.model.Profile;
import br.com.mariolemos.gestao_escolar.security.permission.ResourcePermission;
import br.com.mariolemos.gestao_escolar.service.IProfileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("profile")
@ResourcePermission("PERFIL")
public class ProfileController extends BaseCrudController<ProfileRequest, ProfileResponse, Profile> {

    private IProfileService<Profile> service;

    public ProfileController(IProfileService<Profile> service, IRequest<ProfileRequest, Profile> request, IResponse<Profile, ProfileResponse> response) {
        super(service, request, response);
        this.service = service;
    }

}
