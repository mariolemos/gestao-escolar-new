package br.com.mariolemos.gestao_escolar.service.implement;

import br.com.mariolemos.gestao_escolar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService
        implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(
            String cpf) {

        return repository.findByCpf(cpf)
                .orElseThrow();
    }
}