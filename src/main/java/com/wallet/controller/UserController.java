package com.wallet.controller;

import com.wallet.dto.UserDTO;
import com.wallet.entity.UserEntity;
import com.wallet.response.Response;
import com.wallet.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user") // rota do controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //Binding Result vai conter todas as validações do nosso método

    @PostMapping
    public ResponseEntity<Response<UserDTO>> createUser(@Validated @RequestBody UserDTO userDTO, BindingResult result){

        Response<UserDTO> response = new Response<>();
        if (result.hasErrors()){
            result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        UserEntity userSave = userService.saveUser(this.convertDTOtoEntity(userDTO));
        response.setData(this.convertEntityToDTO(userSave));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);


    }

    private UserEntity convertDTOtoEntity (UserDTO dto){
        UserEntity user = new UserEntity();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        return user;
    }

    private UserDTO convertEntityToDTO (UserEntity entity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getId());
        userDTO.setName(entity.getName());
        userDTO.setEmail(entity.getEmail());
        userDTO.setPassword(entity.getPassword());
        return userDTO;
    }





}
