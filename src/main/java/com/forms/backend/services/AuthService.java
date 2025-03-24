package com.forms.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.forms.backend.entitys.Usuario;
import com.forms.backend.repository.UsuarioRepo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepo usuarioRepo;

    public Usuario login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        // Guardar la autenticación en el contexto de seguridad
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Verificar que el contexto realmente tiene autenticación
        System.out.println("Autenticación después de login: " + SecurityContextHolder.getContext().getAuthentication());

        // Retornar el usuario autenticado
        return usuarioRepo.findByNombre(username);
    }

    public void logout() {
        SecurityContextHolder.clearContext();
    }

    public Usuario getUsuarioAutenticado(HttpServletRequest request) {
    // Imprimir todas las cookies recibidas
    if (request.getCookies() != null) {
        for (Cookie cookie : request.getCookies()) {
            System.out.println("Cookie recibida: " + cookie.getName() + " = " + cookie.getValue());
        }
    } else {
        System.out.println("No se recibieron cookies en la petición.");
    }

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    System.out.println("Autenticación actual: " + authentication);

    if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
        System.out.println("No hay usuario autenticado");
        return null;
    }

    String nombreUsuario = authentication.getName();
    System.out.println("Nombre autenticado: " + nombreUsuario);

    return usuarioRepo.findByNombre(nombreUsuario);
}


}
