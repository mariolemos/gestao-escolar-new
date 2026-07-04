package br.com.mariolemos.gestao_escolar.controller.dto.request;

import br.com.digidata.crud.controller.dto.request.IRequest;
import br.com.mariolemos.gestao_escolar.enumerations.Role;
import br.com.mariolemos.gestao_escolar.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Component
public class UserRequest implements IRequest<UserRequest, User> {

    private UUID id;

    private String cpf;

    private String name;

    private String password;

    private Role role;

    private Boolean active;
    @Override
    public User to(UserRequest userRequest) {
        return User.builder().id(userRequest.getId()).cpf(userRequest.getCpf()).name(userRequest.getName()).active(userRequest.getActive()).password(userRequest.getPassword()).role(userRequest.getRole()).build();
    }

    @Override
    public List<User> to(List<UserRequest> userRequests) {
        return userRequests.stream().map(this::to).toList();
    }

}
