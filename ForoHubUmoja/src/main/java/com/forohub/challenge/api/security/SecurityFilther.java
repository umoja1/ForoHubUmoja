package com.forohub.challenge.api.security;

import com.forohub.challenge.api.domain.repository.UsuarioRepositorio;
import com.forohub.challenge.api.domain.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilther extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var authHeader = request.getHeader("Authorization");
        if (authHeader != null ){
            var token = authHeader.replace("Bearer ", "");
            var subject = tokenService.getSubject(token);
            if (subject != null){
                var usuario = usuarioRepositorio.findByLogin(subject);
                var authentication = new UsernamePasswordAuthenticationToken(
                        usuario, null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        }

        filterChain.doFilter(request, response);
    }
}
