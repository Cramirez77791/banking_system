package com.co.tita.payments.core.entity.payments;

import com.co.tita.payments.core.entity.credits.Credit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userid", nullable = false)
    private Long UserId;

    @Column(name = "quantityquota", nullable = false)
    private double quantityQuotas;

    @ManyToOne
    @JoinColumn(name = "creditId", nullable = false, updatable = false)
    private Credit creditId;

    @Column(name = "paymentdate", nullable = false)
    private Date paymentDate;

    @Column(name = "amount", nullable = false)
    private double amountPayment;


}
