package com.co.tita.payments.core.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankUserDto {
    private Long userId;
    private Long bankId;
}
