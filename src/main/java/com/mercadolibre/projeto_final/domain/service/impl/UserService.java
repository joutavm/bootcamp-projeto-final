package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.User;
import com.mercadolibre.projeto_final.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() ->
            new ItemNotFoundException("Not found", "User not found", 204)
        );
    }

}
