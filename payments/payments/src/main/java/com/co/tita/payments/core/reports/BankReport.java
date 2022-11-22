package com.co.tita.payments.core.reports;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankReport {
    private Long id;
    private String bankName;
    private String message;

}
