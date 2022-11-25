package com.co.tita.payments.core.dtos;

import com.co.tita.payments.core.entity.credits.Credit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private Long userId;
    private double quantityQuotas;
    private Long creditId;
    private String paymentDate;
    private double amountPayment;
}
