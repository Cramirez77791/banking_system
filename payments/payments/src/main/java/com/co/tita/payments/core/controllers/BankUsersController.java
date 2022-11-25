package com.co.tita.payments.core.controllers;

import com.co.tita.payments.core.dtos.BankUserDto;
import com.co.tita.payments.core.entity.bank.BanksUsers;
import com.co.tita.payments.core.reports.BankReport;
import com.co.tita.payments.core.reports.BanksUsersReport;
import com.co.tita.payments.core.reports.ResponseReport;
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

    @GetMapping("/get.all")
    public ResponseEntity<ResponseReport> getBanksByUser(@RequestParam(value = "userid") Long userId){
        ResponseReport reportResponseReport = new ResponseReport<BanksUsersReport>();
        List<BanksUsersReport> banksUsersReportList = bankUsersService.getListBanksUsersByUserId(userId);

        if(Utils.isEmptyList(banksUsersReportList)){
            reportResponseReport.setEntity(banksUsersReportList);
            reportResponseReport.setMessage("Sucess");
            return new ResponseEntity<>(reportResponseReport, null, HttpStatus.OK);
        }
        reportResponseReport.setMessage("Not found");
        return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseReport> addUserToBank(@RequestBody BankUserDto bankUserDto){
        ResponseReport reportResponseReport = new ResponseReport<BanksUsersReport>();

        if(null == bankUserDto){
            reportResponseReport.setMessage("The dto can't be null");
         return new ResponseEntity<>(reportResponseReport,null,HttpStatus.BAD_REQUEST);
        }

        if(null == bankUserDto.getBankId()){
            reportResponseReport.setMessage("The bankId can't be null");
            return new ResponseEntity<>(reportResponseReport,null,HttpStatus.BAD_REQUEST);
        }

        if(null == bankUserDto.getUserId()){
            reportResponseReport.setMessage("The userId can't be null");
            return new ResponseEntity<>(reportResponseReport,null,HttpStatus.BAD_REQUEST);
        }

        Long banksUsersId = bankUsersService.saveBankUsers(bankUserDto.getUserId(), bankUserDto.getBankId());

        BanksUsersReport banksUsersReport  = bankUsersService.getById(banksUsersId);

        reportResponseReport.setMessage("Sucess");
        reportResponseReport.setEntity(banksUsersReport);
        return new ResponseEntity<>(reportResponseReport,null,HttpStatus.CREATED);

    }

    @GetMapping("/get")
    public ResponseEntity<ResponseReport> getBanksById(@RequestParam(value = "id") Long Id){
        ResponseReport reportResponseReport = new ResponseReport<BanksUsersReport>();
        BanksUsersReport banksUsersReportList = bankUsersService.getById(Id);

        if(null != banksUsersReportList){
            reportResponseReport.setEntity(banksUsersReportList);
            reportResponseReport.setMessage("Sucess");
            return new ResponseEntity<>(reportResponseReport, null, HttpStatus.OK);
        }
        reportResponseReport.setMessage("Not found");
        return new ResponseEntity<>(null, null, HttpStatus.NOT_FOUND);
    }


}
