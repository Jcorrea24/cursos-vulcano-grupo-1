package com.grupo1.cursosvulcano.service;

import org.springframework.stereotype.Service;

import com.grupo1.cursosvulcano.model.entity.User;
import com.grupo1.cursosvulcano.model.entity.UserProfile;
import com.grupo1.cursosvulcano.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Genera el constructor para la inyección de dependencias
public class UserService {

    private final UserRepository userRepository;

    /**
     * Crea un nuevo usuario junto con su perfil.
     * Gracias al método helper setProfile y al CascadeType.ALL,
     * ambos se guardan en una sola operación.
     */
    @Transactional
    public User createUser(User user, UserProfile profile) {
        // Usamos el método helper que creamos para vincular ambos objetos en memoria
        user.setProfile(profile);
        
        // Al guardar el usuario, se guarda el perfil automáticamente por el cascade
        return userRepository.save(user);
    }

    /**
     * Obtiene un usuario por ID.
     */
    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }

    /**
     * Elimina un usuario y, debido a CascadeType.ALL, también eliminará su perfil.
     */
    @Transactional
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
