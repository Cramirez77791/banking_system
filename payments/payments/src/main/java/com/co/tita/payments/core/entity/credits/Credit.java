package com.co.tita.payments.core.entity.credits;

import com.co.tita.payments.core.entity.bank.Bank;
import com.co.tita.payments.core.entity.payments.Payment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date creditDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="bankId",referencedColumnName = "id")
    private Bank bankId;

    @Column(name = "userid", nullable = false)
    private Long userId;

    @OneToMany(mappedBy = "creditId")
    private List<Payment> payments;

}
