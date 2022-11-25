package com.co.tita.payments.core.controllers;

import com.co.tita.payments.core.dtos.BankDto;
import com.co.tita.payments.core.entity.bank.Bank;
import com.co.tita.payments.core.entity.bank.BanksUsers;
import com.co.tita.payments.core.reports.BankReport;
import com.co.tita.payments.core.reports.BanksUsersReport;
import com.co.tita.payments.core.reports.ResponseReport;
import com.co.tita.payments.core.reports.UserReport;
import com.co.tita.payments.core.service.banks.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/create")
    public ResponseEntity<ResponseReport> addBank(@RequestBody BankDto bankDto){
        ResponseReport reportResponseReport = new ResponseReport<BankReport>();
        BankReport bankReport = new BankReport();
        if(null == bankDto){
            reportResponseReport.setMessage("The dto can't be empty");
            return new ResponseEntity<>(reportResponseReport,null, HttpStatus.BAD_REQUEST);
        }
       Bank bank = bankService.saveBank(bankDto);
         bankReport.setBankName(bank.getBankName());
         bankReport.setId(bank.getId());
         reportResponseReport.setEntity(bankReport);
         reportResponseReport.setMessage("Sucess");
         return new ResponseEntity<>(reportResponseReport,null,HttpStatus.OK);
    }



    @GetMapping("/get.all")
    public ResponseEntity<ResponseReport> getUserData(@RequestParam("userid") Long userid){
        ResponseReport reportResponseReport = new ResponseReport<BankReport>();
        List<BanksUsersReport> userReport =bankService.getBanksByUserId(userid);
        reportResponseReport.setEntity(userReport);
        return new ResponseEntity<>(reportResponseReport,null,HttpStatus.OK);
    }

}
