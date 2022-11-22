package com.co.tita.payments.core.service.banks;

import com.co.tita.payments.core.dtos.BankDto;
import com.co.tita.payments.core.entity.bank.Bank;
import com.co.tita.payments.core.entity.bank.BanksUsers;


import java.util.List;

public interface BankService {

    public List<BanksUsers> getBanksByUserId(Long userId);

    public Bank saveBank(BankDto bankDto);

}
