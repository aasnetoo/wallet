package com.wallet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet.dto.UserDTO;
import com.wallet.entity.UserEntity;
import com.wallet.service.impl.UserServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@DataJpaTest
public class UserControllerTest {

    private static final String EMAIL = "email@teste.com";
    private static final String NAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String URL = "/user";

    @MockBean
    UserServiceImpl userService;

    @Autowired
    MockMvc mvc;

    public void testSave() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());



    }

    public UserEntity getMockUser(){
        UserEntity user = new UserEntity();
        user.setEmail(EMAIL);
        user.setName(NAME);
        user.setPassword(PASSWORD);

        return user;
    }

    public String getJsonPayload() throws JsonProcessingException {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(EMAIL);
        userDTO.setName(NAME);
        userDTO.setPassword(PASSWORD);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userDTO);
    }



}
