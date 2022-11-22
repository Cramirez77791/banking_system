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
    @JoinColumn(name = "fk_users", nullable = false, updatable = false)
    private User idUser;

    @ManyToOne
    @JoinColumn(name = "fk_roles", nullable = false, updatable = false)
    private Roles idRol;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
