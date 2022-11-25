package com.co.tita.payments.core.reports;


import com.co.tita.payments.core.entity.bank.Bank;
import com.co.tita.payments.core.entity.users.User;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BanksUsersReport implements Serializable {
    private Long id;
    private User idUser;
    private BankReport idBank;
    private String message;
}
