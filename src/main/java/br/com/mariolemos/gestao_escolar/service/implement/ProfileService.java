package br.com.mariolemos.gestao_escolar.service.implement;

import br.com.digidata.crud.service.CrudService;
import br.com.mariolemos.gestao_escolar.model.Profile;
import br.com.mariolemos.gestao_escolar.repository.ProfileRepository;
import br.com.mariolemos.gestao_escolar.service.IProfileService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileService extends CrudService<Profile, UUID> implements IProfileService<Profile> {

    private ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
