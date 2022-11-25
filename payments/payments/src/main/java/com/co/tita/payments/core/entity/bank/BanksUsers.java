package com.co.tita.payments.core.entity.bank;
import com.co.tita.payments.core.entity.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity(name = "banks_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BanksUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser",referencedColumnName = "id")
    private User idUser;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="idBank",referencedColumnName = "id")
    private Bank idBank;

}
