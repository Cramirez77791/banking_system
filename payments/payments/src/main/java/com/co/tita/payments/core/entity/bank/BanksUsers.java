package com.co.tita.payments.core.entity.bank;
import com.co.tita.payments.core.entity.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

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

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "iduser", nullable = false, updatable = false)
    private User idUser;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name ="idbank", nullable = false, updatable = false)
    private Bank idBank;

}
