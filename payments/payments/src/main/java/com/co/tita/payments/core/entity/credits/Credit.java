package com.co.tita.payments.core.entity.credits;

import com.co.tita.payments.core.entity.bank.Bank;
import com.co.tita.payments.core.entity.payments.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity(name = "credits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Credit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "quotaquantity", nullable = false)
    private double quotaQuantity;

    @Column(name = "quotaamount", nullable = false)
    private double quotaAmount;

    @Column(name = "creditdate", nullable = false)
    private Date creditDate;

    @ManyToOne
    @JoinColumn(name = "fk_credit_banks", nullable = false, updatable = false)
    private Bank bankId;

    @Column(name = "userid", nullable = false)
    private Long userId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditId")
    private List<Payment> payments;

}
