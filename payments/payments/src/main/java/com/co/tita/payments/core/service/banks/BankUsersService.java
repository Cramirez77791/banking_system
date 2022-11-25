package com.co.tita.payments.core.service.banks;

import com.co.tita.payments.core.entity.bank.BanksUsers;
import com.co.tita.payments.core.reports.BanksUsersReport;

import java.util.List;

public interface BankUsersService {

    List<BanksUsersReport> getListBanksUsersByUserId(Long userId);

    Long saveBankUsers(Long userId, Long bankId);

    BanksUsersReport getById(Long id);
}
