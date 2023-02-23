package com.wallet.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDTO {

    private Long id;
    @Length(min=3, max = 50, message = "The name must contain between 3 and 50 characters.")
    private String name;

    @Length(min=6, message = "The password must contain at least 3 characters.")
    @NotNull
    private String password;
    @Email(message = "Email is not valid")
    @NotNull(message = "Email cannot be empty")
    private String email;

}
