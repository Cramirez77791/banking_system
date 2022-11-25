package com.co.tita.payments.core.service.banks.impl;

import com.co.tita.payments.core.entity.bank.Bank;
import com.co.tita.payments.core.entity.bank.BanksUsers;
import com.co.tita.payments.core.entity.users.User;
import com.co.tita.payments.core.reports.BankReport;
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
                BankReport bankReport = new BankReport();
                bankReport.setBankName(bank.getIdBank().getBankName());
                bankReport.setId(bank.getIdBank().getId());
                banksUsersReport.setIdBank(bankReport);
                banksUsersReport.setIdUser(bank.getIdUser());
                banksUsersReports.add(banksUsersReport);
            });
            return banksUsersReports;
        }
        return null;
    }

    @Override
    @Transactional
    public Long saveBankUsers(Long userId, Long bankId) {
     BanksUsers  banksUsers = new BanksUsers();
     Bank bank = new Bank();
     bank.setId(bankId);
     banksUsers.setIdBank(bank);

     User user = new User();
     user.setId(userId);
     banksUsers.setIdUser(user);

     bankUsersRepository.saveAndFlush(banksUsers);
     return banksUsers.getId();
    }

    @Override
    @Transactional
    public BanksUsersReport getById(Long id) {
        BanksUsersReport banksUsersReport = new BanksUsersReport();
        Optional<BanksUsers> optionalBanksUsers = bankUsersRepository.getBanksUsersById(id);

        if(optionalBanksUsers.isPresent()){
            BanksUsers banksUsers1 = optionalBanksUsers.get();
            banksUsersReport.setId(banksUsers1.getId());
            banksUsersReport.setIdUser(banksUsers1.getIdUser());
            BankReport bankReport = new BankReport();
            bankReport.setId(banksUsers1.getIdBank().getId());
            bankReport.setBankName(banksUsers1.getIdBank().getBankName());
            banksUsersReport.setIdBank(bankReport);
        }
        return banksUsersReport;
    }


}
