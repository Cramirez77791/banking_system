package com.co.tita.payments.core.reports;

import com.co.tita.payments.core.entity.bank.Bank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreditDetailReport {
    private Long id;
    private double amount;
    private double quotaQuantity;
    private double quotaAmount;
    private String creditDate;
    private Bank bankId;
    private Long userId;
    private List<PaymentCreditReport> paymentReportList;
}
