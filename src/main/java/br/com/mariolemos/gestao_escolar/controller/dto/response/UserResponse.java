package br.com.mariolemos.gestao_escolar.controller.dto.response;

import br.com.digidata.crud.controller.dto.response.IResponse;
import br.com.mariolemos.gestao_escolar.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements IResponse<User, UserResponse> {

    private UUID id;

    private String cpf;

    @JsonIgnore
    private String password;

    private String name;

    private Boolean active;

    @Override
    public UserResponse to(User user) {
        return UserResponse.builder().id(user.getId()).cpf(user.getCpf()).name(user.getName()).active(user.getActive()).password(user.getPassword()).build();
    }

    @Override
    public List<UserResponse> to(List<User> users) {
        return users.stream().map(this::to).toList();
    }
}
