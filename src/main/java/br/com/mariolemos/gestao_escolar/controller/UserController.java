package br.com.mariolemos.gestao_escolar.controller;

import br.com.digidata.crud.controller.CrudController;
import br.com.digidata.crud.controller.dto.request.IRequest;
import br.com.digidata.crud.controller.dto.response.IResponse;
import br.com.mariolemos.gestao_escolar.controller.dto.request.UserRequest;
import br.com.mariolemos.gestao_escolar.controller.dto.response.UserResponse;
import br.com.mariolemos.gestao_escolar.model.User;
import br.com.mariolemos.gestao_escolar.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends CrudController<UserRequest, UserResponse, User> {

    public UserController(IUserService<User> service, IRequest<UserRequest, User> request, IResponse<User, UserResponse> response) {
        super(service, request, response);
    }
}
