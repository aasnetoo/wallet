package com.wallet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1693850165739564098L;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;


}
