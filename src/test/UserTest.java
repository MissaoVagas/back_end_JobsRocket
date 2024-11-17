package com.back_end.JobsRocket.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.back_end.JobsRocket.model.enums.Role;

public class UserTest {

    @Test
    public void testGettersAndSetters() {
        User user = new User();
        user.setNome("Maria Oliveira");
        user.setEmail("maria.oliveira@example.com");
        user.setRole(Role.USER); 
        user.setSenha("senhaSegura123");

        assertEquals("Maria Oliveira", user.getNome());
        assertEquals("maria.oliveira@example.com", user.getEmail());
        assertEquals(Role.USER, user.getRole());
        assertEquals("senhaSegura123", user.getSenha());
    }

    @Test
    public void testNotBlankNome() {
        User user = new User();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setNome(""); // Tentativa de definir um nome vazio
        });
        
        String expectedMessage = "O nome não pode estar em branco"; 
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testEmailValidation() {
        User user = new User();
        
        // Teste com email inválido
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            user.setEmail("emailinvalido"); // Tentativa de definir um email inválido
        });
        
        String expectedMessage = "Email inválido"; 
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
