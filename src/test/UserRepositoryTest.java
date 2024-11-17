package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setNome("Ana Souza");
        user.setEmail("ana.souza@example.com");
        user.setSenha("senhaSegura123");
        userRepository.save(user);
    }

    @Test
    public void testFindByEmail() {
        Optional<User> userOptional = userRepository.findByEmail("ana.souza@example.com");
        assertThat(userOptional).isPresent();
        assertThat(userOptional.get().getNome()).isEqualTo("Ana Souza");
    }

    @Test
    public void testFindById() {
        Optional<User> foundUser = userRepository.findById(user.getUser_id());
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getNome()).isEqualTo("Ana Souza");
    }

    @Test
    public void testFindAll() {
        List<User> users = userRepository.findAll();
        assertThat(users).isNotEmpty();
        assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    public void testDelete() {
        userRepository.delete(user);
        
        // Verifica se o usuário foi realmente deletado
        assertThat(userRepository.findById(user.getUser_id())).isEmpty();
    }
}
