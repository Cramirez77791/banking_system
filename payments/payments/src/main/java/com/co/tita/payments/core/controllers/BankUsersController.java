package com.co.tita.payments.core.controllers;

import com.co.tita.payments.core.dtos.BankUserDto;
import com.co.tita.payments.core.entity.bank.BanksUsers;
import com.co.tita.payments.core.reports.BanksUsersReport;
import com.co.tita.payments.core.service.banks.BankUsersService;
import com.co.tita.payments.core.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankusers")
public class BankUsersController {

    @Autowired
    private BankUsersService bankUsersService;

    @GetMapping("/get")
    public ResponseEntity<List<BanksUsersReport>> getBanksByUser(@RequestParam(value = "userid") Long userId){
        List<BanksUsersReport> banksUsersReportList = bankUsersService.getListBanksUsersByUserId(userId);
        if(Utils.isEmptyList(banksUsersReportList)){
            return new ResponseEntity<>(banksUsersReportList, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<BanksUsersReport> addUserToBank(@RequestBody BankUserDto bankUserDto){
        BanksUsersReport banksUsersReport = new BanksUsersReport();
        if(null == bankUserDto){
            banksUsersReport.setMessage("The dto can't be null");
         return new ResponseEntity<>(banksUsersReport,null,HttpStatus.BAD_REQUEST);
        }

        if(null == bankUserDto.getBankId()){
            banksUsersReport.setMessage("The bankId can't be null");
            return new ResponseEntity<>(banksUsersReport,null,HttpStatus.BAD_REQUEST);
        }

        if(null == bankUserDto.getUserId()){
            banksUsersReport.setMessage("The userId can't be null");
            return new ResponseEntity<>(banksUsersReport,null,HttpStatus.BAD_REQUEST);
        }

        BanksUsers banksUsers = bankUsersService.saveBankUsers(bankUserDto.getUserId(), bankUserDto.getBankId());

        banksUsersReport.setIdBank(banksUsers.getIdBank());
        banksUsersReport.setIdUser(banksUsers.getIdUser());
        banksUsersReport.setId(banksUsers.getId());
        banksUsersReport.setMessage("Sucess");
        return new ResponseEntity<>(banksUsersReport,null,HttpStatus.CREATED);

    }

}
