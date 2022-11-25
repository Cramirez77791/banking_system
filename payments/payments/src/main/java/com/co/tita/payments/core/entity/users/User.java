package com.co.tita.payments.core.entity.users;

import com.co.tita.payments.core.entity.bank.BanksUsers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;


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
    @Column(name ="fullname", nullable = false)
    private String fullName;

}
