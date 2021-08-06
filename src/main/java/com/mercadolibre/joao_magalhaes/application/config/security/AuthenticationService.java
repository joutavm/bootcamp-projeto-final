package com.mercadolibre.joao_magalhaes.application.config.security;

import com.mercadolibre.joao_magalhaes.domain.model.User;
import com.mercadolibre.joao_magalhaes.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByName(name);
        if(optionalUser.isEmpty()){
            throw new UsernameNotFoundException("Invalid credentials");
        }
        return optionalUser.get();
    }
}
