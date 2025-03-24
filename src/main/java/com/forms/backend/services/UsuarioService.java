package com.forms.backend.services;

import com.forms.backend.entitys.Usuario;
import com.forms.backend.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private PasswordEncoder passwordEncoder; // Usa el Bean de SecurityConfig

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        return usuarioRepo.findAll();
    }

    // Obtener usuario por id
    public Usuario getUsuarioById(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    // Crear un nuevo usuario con la contraseña encriptada
    public Usuario registrarUsuario(Usuario usuario) {
        if (usuarioRepo.findByNombre(usuario.getNombre()) != null) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }

        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));

        // Asegurar que la lista de roles nunca sea null
        Set<String> roles = usuario.getRoles();
        if (roles == null) {
            roles = new HashSet<>(); // Inicializarlo si es null
        }

        roles.add("USER"); // Agregar el rol USER por defecto
        usuario.setRoles(roles); // Establecer la lista de roles en el usuario

        return usuarioRepo.save(usuario);
    }

}
