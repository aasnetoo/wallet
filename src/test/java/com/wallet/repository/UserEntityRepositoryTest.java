package com.wallet.repository;

import entity.UserEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import repository.UserRepository;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UserEntityRepositoryTest {

    public static final String EMAIL = "email@teste.com";

    @Autowired
    UserRepository repository;

    @Before
    public void setUp(){ // Instruções que serão testadas antes dos testes.
        UserEntity user = new UserEntity();
        user.setName("Set up User");
        user.setPassword("Senha123");
        user.setEmail(EMAIL);
        repository.save(user);

    }

    @After
    public void tearDown(){ // Instruções que serão executadas após as finalizações dos testes.
        repository.deleteAll();
    }

    @Test
    public void testSave(){
        UserEntity user = new UserEntity();
        user.setName("Teste");
        user.setPassword("123456");
        user.setEmail("teste@teste.com");

        UserEntity response = repository.save(user);

        assertNotNull(response);
    }

    @Test
    public void testFindByEmail(){
        Optional<UserEntity> response = repository.findByEmailEquals(EMAIL);

        assertTrue(response.isPresent());
        assertEquals(response.get().getEmail(),EMAIL);
    }
}
