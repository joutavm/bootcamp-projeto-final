package com.mercadolibre.joao_magalhaes.application.config.security;

import com.mercadolibre.joao_magalhaes.domain.model.User;
import com.mercadolibre.joao_magalhaes.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = getToken(httpServletRequest);
        boolean valido = tokenService.isTokenValid(token);
        if (valido){
            authenticateUser(token);
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer "))
            return null;
        return token.substring(7, token.length());
    }

    private void authenticateUser(String token){
        Long id = tokenService.getIdUser(token);
        User user = userRepository.findById(id).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
