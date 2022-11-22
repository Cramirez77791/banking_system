package com.co.tita.payments.core.service.banks.impl;

import com.co.tita.payments.core.entity.bank.Bank;
import com.co.tita.payments.core.entity.bank.BanksUsers;
import com.co.tita.payments.core.entity.users.User;
import com.co.tita.payments.core.reports.BanksUsersReport;
import com.co.tita.payments.core.repository.banks.BankUsersRepository;
import com.co.tita.payments.core.service.banks.BankUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankUsersServiceImpl implements BankUsersService {

    @Autowired
    private BankUsersRepository bankUsersRepository;

    @Override
    @Transactional
    public List<BanksUsersReport> getListBanksUsersByUserId(Long userId) {
        User user = new User();
        user.setId(userId);
        Optional<List<BanksUsers>> banksUsersList = bankUsersRepository.findBanksUsersByIdUser(user);
        if(banksUsersList.isPresent()){
            List<BanksUsersReport> banksUsersReports = new ArrayList<>();
            List<BanksUsers> banksUsers = banksUsersList.get();
            banksUsers.forEach(bank -> {
                BanksUsersReport banksUsersReport = new BanksUsersReport();
                banksUsersReport.setId(bank.getId());
                banksUsersReport.setIdBank(bank.getIdBank());
                banksUsersReport.setIdUser(bank.getIdUser());
                banksUsersReports.add(banksUsersReport);
            });
            return banksUsersReports;
        }
        return null;
    }

    @Override
    public BanksUsers saveBankUsers(Long userId, Long bankId) {
     BanksUsers  banksUsers = new BanksUsers();
     Bank bank = new Bank();
     bank.setId(bankId);
     banksUsers.setIdBank(bank);

     User user = new User();
     user.setId(userId);
     banksUsers.setIdUser(user);

     bankUsersRepository.saveAndFlush(banksUsers);

     Optional<BanksUsers> optionalBanksUsers = bankUsersRepository.findById(banksUsers.getId());

     if(optionalBanksUsers.isPresent()){
         banksUsers = optionalBanksUsers.get();
     }

        return banksUsers;
    }
}
