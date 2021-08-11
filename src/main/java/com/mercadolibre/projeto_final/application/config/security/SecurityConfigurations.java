package com.mercadolibre.projeto_final.application.config.security;

import com.mercadolibre.projeto_final.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    private final AuthenticationService authenticationService;
    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // Authentication config
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // Authorization config
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/v1/fresh-products/inboundorder/").hasAuthority("representante")
                .antMatchers(HttpMethod.PUT,"/api/v1/fresh-products/inboundorder/").hasAuthority("representante")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/warehouse/*").hasAuthority("representante")
                .antMatchers( "/api/v1/fresh-products/orders/**").hasAuthority("comprador")
                .antMatchers( "/api/v1/fresh-products/*").hasAuthority("comprador")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/list").hasAuthority("representante")
                .antMatchers(HttpMethod.GET, "/api/v1/fresh-products/warehouse/*").hasAuthority("representante")
                .antMatchers(HttpMethod.GET, "/ping").permitAll()
                .antMatchers(HttpMethod.POST,"/auth").permitAll()
                .and().addFilterBefore(new TokenAuthenticationFilter(tokenService, userRepository), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();
    }


}