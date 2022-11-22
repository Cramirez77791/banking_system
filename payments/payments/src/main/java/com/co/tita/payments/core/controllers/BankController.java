package com.co.tita.payments.core.controllers;

import com.co.tita.payments.core.dtos.BankDto;
import com.co.tita.payments.core.entity.bank.Bank;
import com.co.tita.payments.core.reports.BankReport;
import com.co.tita.payments.core.service.banks.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/create")
    public ResponseEntity<BankReport> addBank(@RequestBody BankDto bankDto){
       BankReport bankReport = new BankReport();
        if(null == bankDto){
            bankReport.setMessage("The dto can't be empty");
            return new ResponseEntity<>(bankReport,null, HttpStatus.BAD_REQUEST);
        }
       Bank bank = bankService.saveBank(bankDto);
         bankReport.setBankName(bank.getBankName());
         bankReport.setId(bank.getId());
         bankReport.setMessage("Sucess");
         return new ResponseEntity<>(bankReport,null,HttpStatus.OK);
    }



}
