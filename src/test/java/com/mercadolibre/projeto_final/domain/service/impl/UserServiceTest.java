package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.application.util.MockitoExtension;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.User;
import com.mercadolibre.projeto_final.domain.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    void shouldReturnUserWhenSearchByValidId() {
        // Given
        User expect = new User();
        Long id = 1L;

        // when
        when(userRepository.findById(any())).thenReturn(Optional.of(expect));
        User result = userService.findById(id);

        // then
        assertEquals(expect, result);
    }

    @Test
    void shouldThrowExceptionWhenSearchByInvalidId() {
        // Given
        Long id = 1L;

        // when
        when(userRepository.findById(any())).thenReturn(Optional.empty());

        // then
        assertThrows(ItemNotFoundException.class, () -> userService.findById(id));
    }
}