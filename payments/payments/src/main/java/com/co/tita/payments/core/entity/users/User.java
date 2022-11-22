package com.co.tita.payments.core.entity.users;

import com.co.tita.payments.core.entity.bank.BanksUsers;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;



@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="username", nullable = false)
    private String userName;
    @Column(name ="password", nullable = false)
    private String passWord;
    @Column(name ="isactive", nullable = false)
    private boolean isActive;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<UserRoles> roles;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<BanksUsers> banks;

}
