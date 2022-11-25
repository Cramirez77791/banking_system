package com.co.tita.payments.core.entity.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "users_roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRoles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false, updatable = false)
    private User idUser;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false, updatable = false)
    private Roles idRol;


}
