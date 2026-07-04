package br.com.mariolemos.gestao_escolar.service.implement;

import br.com.mariolemos.gestao_escolar.exception.UnauthorizedException;
import br.com.mariolemos.gestao_escolar.model.User;
import br.com.mariolemos.gestao_escolar.repository.UserRepository;
import br.com.mariolemos.gestao_escolar.service.IAuthService;
import com.digidata.escolar_geolocation.controller.dto.request.LoginRequest;
import com.digidata.escolar_geolocation.controller.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request) {

        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.cpf(),
                            request.password()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new UnauthorizedException("Usuário ou senha inválidos");
        }
        catch (Exception e){
            System.out.println("Erro ao fazer login");
        }
        User user = repository.findByCpf(request.cpf())
                .orElseThrow();

        String token = jwtService.generateToken(user);

        return new LoginResponse(token, "",user.getName(), user.getCpf());
    }
}