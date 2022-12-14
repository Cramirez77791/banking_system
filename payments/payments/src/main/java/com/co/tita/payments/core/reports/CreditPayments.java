package com.co.tita.payments.core.reports;

import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreditPayments implements Serializable {
    private Long id;
    private double amount;
    private double quotaQuantity;
    private double quotaAmount;
    private String creditDate;
    private String bankName;
    private Long bankId;
    private double quotaQuntityPending;
    private double amountPending;
    private List<PaymentCreditReport> paymentReportList;
}
