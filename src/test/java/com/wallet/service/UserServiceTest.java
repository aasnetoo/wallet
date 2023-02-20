package com.wallet.service;

import com.wallet.entity.UserEntity;
import com.wallet.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserServiceTest {

    @MockBean
    UserRepository repository;

    @Before
    public void setUp(){
        BDDMockito.given(repository.findByEmailEquals(Mockito.anyString())).willReturn(Optional.of(new UserEntity()));

    }

    @Test
    public void testFindByEmail(){

    }

}
