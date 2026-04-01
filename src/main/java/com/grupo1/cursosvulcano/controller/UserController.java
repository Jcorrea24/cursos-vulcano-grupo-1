package com.grupo1.cursosvulcano.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo1.cursosvulcano.model.entity.User;
import com.grupo1.cursosvulcano.model.entity.UserProfile;
import com.grupo1.cursosvulcano.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Crear un usuario y su perfil simultáneamente.
     * El JSON enviado debe tener una estructura anidada para el perfil.
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Extraemos el perfil que viene dentro del objeto User
        UserProfile profile = user.getProfile();
        
        // Llamamos al servicio que ya tiene la lógica del método helper y el cascade
        User savedUser = userService.createUser(user, profile);
        
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /**
     * Obtener un usuario por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    /**
     * Eliminar un usuario (esto también borrará su perfil por el CascadeType.ALL).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
