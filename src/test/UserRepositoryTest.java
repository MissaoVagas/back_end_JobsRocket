package com.back_end.JobsRocket.repository;

import com.back_end.JobsRocket.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        User user = new User();
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
}
