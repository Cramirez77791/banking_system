package com.co.tita.payments.core.service.banks.impl;

import com.co.tita.payments.core.dtos.BankDto;
import com.co.tita.payments.core.entity.bank.Bank;
import com.co.tita.payments.core.entity.bank.BanksUsers;
import com.co.tita.payments.core.entity.users.User;
import com.co.tita.payments.core.reports.BankReport;
import com.co.tita.payments.core.reports.BanksUsersReport;
import com.co.tita.payments.core.repository.banks.BankRepository;
import com.co.tita.payments.core.repository.banks.BankUsersRepository;
import com.co.tita.payments.core.service.banks.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankUsersRepository bankUsersRepository;

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<BanksUsersReport> getBanksByUserId(Long userId) {

        List<BanksUsersReport> list =new ArrayList<>();
        User user = new User();
        user.setId(userId);
        Optional<List<BanksUsers>> banksUsers = bankUsersRepository.findBanksUsersByIdUser(user);
        if(banksUsers.isPresent()){
            List<BanksUsers>  banksUser = banksUsers.get();
            banksUser.forEach(bank -> {
                BanksUsersReport banksUsersReport = new BanksUsersReport();
                BankReport bankReport = new BankReport();
                bankReport.setId(bank.getId());
                bankReport.setBankName(bank.getIdBank().getBankName());
                banksUsersReport.setIdBank(bankReport);
                banksUsersReport.setIdUser(bank.getIdUser());
                        list.add(banksUsersReport);
                    });
        }
        return list;
    }

    @Override
    public Bank saveBank(BankDto bankDto) {
        Bank bank = new Bank();
        bank.setBankName(bankDto.getBankName());
        bankRepository.saveAndFlush(bank);
        return bank;
    }


}
