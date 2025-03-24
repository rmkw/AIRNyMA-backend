package com.forms.backend.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import com.forms.backend.entitys.LoginDTO;
import com.forms.backend.entitys.Usuario;
import com.forms.backend.entitys.UsuarioDTO;
import com.forms.backend.services.AuthService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/auth")
public class AuthControllers {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO, HttpServletRequest request) {
        try {
            Usuario usuario = authService.login(loginDTO.getUsername(), loginDTO.getPassword());

            // Autenticar manualmente en el contexto de seguridad
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("Autenticación después de login: " + auth);

            // Estructurar la respuesta con "user"
            Map<String, Object> response = new HashMap<>();
            response.put("user", usuario);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", "El usuario o la contraseña son incorrectos"));
        }
    }



    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            System.out.println(" No hay sesión activa en el backend");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No hay sesión activa");
        }

        System.out.println(" Cerrando sesión para ID: " + session.getId());

        session.invalidate();
        SecurityContextHolder.clearContext();

        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(true); // Si usas HTTPS
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return ResponseEntity.ok("Sesión cerrada exitosamente");
    }


    @GetMapping("/usuario")
    public ResponseEntity<Map<String, Object>> getUsuarioAutenticado(HttpServletRequest request) {
        Usuario usuario = authService.getUsuarioAutenticado(request);
        Map<String, Object> response = new HashMap<>();

        if (usuario == null) {
            response.put("authenticated", false);
            response.put("message", "No hay usuario autenticado");
            return ResponseEntity.ok(response); // Devuelve 200 en lugar de 401
        }

        response.put("authenticated", true);
        response.put("user", new UsuarioDTO(usuario.getId(), usuario.getNombre(), usuario.getRoles()));

        return ResponseEntity.ok(response);
    }

}
