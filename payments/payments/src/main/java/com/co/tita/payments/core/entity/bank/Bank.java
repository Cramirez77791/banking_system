package com.co.tita.payments.core.entity.bank;

import com.co.tita.payments.core.entity.credits.Credit;
import com.co.tita.payments.core.entity.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "banks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bankname", nullable = false)
    private String bankName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBank")
    private List<BanksUsers> users;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankId")
    private List<Credit> credits;


}
